<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Quản lý sản phẩm</title>
    <style>
        /* Giữ nguyên CSS bạn đã viết */
        body { font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif; background-color: #f9f9f9; margin: 30px; color: #333; }
        h2 { color: #0056b3; text-align: center; margin-bottom: 30px; }
        form { width: 90%; max-width: 600px; margin: 0 auto 40px auto; padding: 20px; background-color: white; box-shadow: 0 2px 8px rgba(0,0,0,0.1); border-radius: 6px; display: flex; gap: 15px; align-items: center; }
        form input[type="text"], form input[type="number"] { flex: 1; padding: 10px 12px; border: 1px solid #ccc; border-radius: 4px; font-size: 1em; }
        form button { padding: 10px 20px; background-color: #007bff; border: none; border-radius: 4px; color: white; font-weight: 600; cursor: pointer; transition: background-color 0.3s ease; }
        form button:hover { background-color: #0056b3; }
        table { width: 90%; margin: 0 auto; border-collapse: collapse; background-color: white; box-shadow: 0 2px 8px rgba(0,0,0,0.1); border-radius: 6px; overflow: hidden; }
        th, td { padding: 12px 20px; border-bottom: 1px solid #ddd; text-align: center; }
        th { background-color: #007bff; color: white; text-transform: uppercase; letter-spacing: 0.1em; }
        tr:hover { background-color: #f1f7ff; }
        .price { color: #28a745; font-weight: bold; }
        .no-data { text-align: center; font-style: italic; padding: 20px; color: #888; }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>Quản lý sản phẩm</h2>

<!-- Form thêm sản phẩm -->
<form id="productForm">
    <input type="text" id="name" name="name" placeholder="Tên sản phẩm" required />
    <input type="number" id="price" name="price" placeholder="Giá (VNĐ)" min="0" required />
    <button type="submit">Thêm sản phẩm</button>
</form>

<!-- Bảng danh sách sản phẩm -->
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá (VNĐ)</th>
    </tr>
    </thead>
    <tbody id="productTableBody">
    <tr><td colspan="3" class="no-data">Đang tải dữ liệu...</td></tr>
    </tbody>
</table>

<script>
    $(document).ready(function() {
        // Hàm load danh sách sản phẩm từ API
        function loadProducts() {
            $.ajax({
                url: '${pageContext.request.contextPath}/api/products',
                method: 'GET',
                dataType: 'json',
                success: function(products) {
                    var tbody = $('#productTableBody');
                    tbody.empty();
                    if (products.length === 0) {
                        tbody.append('<tr><td colspan="3" class="no-data">Không có sản phẩm nào.</td></tr>');
                    } else {
                        $.each(products, function(index, product) {
                            tbody.append('<tr><td>' + product.id + '</td><td>' + product.name + '</td><td class="price">' + product.price + '</td></tr>');
                        });
                    }
                },
                error: function() {
                    alert('Lỗi tải danh sách sản phẩm.');
                }
            });
        }

        // Gọi load danh sách khi trang được tải
        loadProducts();

        // Bắt sự kiện submit form thêm sản phẩm bằng AJAX
        $('#productForm').submit(function(e) {
            e.preventDefault(); // chặn form submit reload trang

            var name = $('#name').val().trim();
            var price = $('#price').val();

            if (!name || price < 0) {
                alert('Vui lòng nhập tên sản phẩm và giá hợp lệ.');
                return;
            }

            // Gửi dữ liệu sản phẩm mới lên API
            $.ajax({
                url: '${pageContext.request.contextPath}/api/products',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify({ name: name, price: price }),
                success: function() {
                    $('#name').val('');
                    $('#price').val('');
                    loadProducts(); // tải lại danh sách mới
                },
                error: function() {
                    alert('Lỗi thêm sản phẩm.');
                }
            });
        });
    });
</script>

</body>
</html>
