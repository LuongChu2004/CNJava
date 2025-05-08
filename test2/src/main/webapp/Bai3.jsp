<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <!-- Bootstrap CSS từ CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body class="bg-light">
    <div class="container">
        <div class="row justify-content-center" style="height: 100vh; align-items: center;">
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h3 class="text-center mb-4">Đăng Nhập</h3>
                        <form>
                            <div class="form-group">
                                <label for="username">Tên đăng nhập</label>
                                <input type="text" class="form-control" id="username" placeholder="Nhập tên đăng nhập" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" placeholder="Nhập mật khẩu" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Đăng Nhập</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS và các thư viện phụ trợ -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    