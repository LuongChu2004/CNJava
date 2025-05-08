<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký</title>
    <!-- Bootstrap CSS từ CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    
</head>
<body class="bg-light">
    <div class="container">
        <div class="row justify-content-center" style="height: 100vh; align-items: center;">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h3 class="text-center mb-4">Đăng Ký</h3>
                        <form>
                            <!-- Email -->
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" placeholder="Nhập email" required>
                            </div>

                            <!-- Password -->
                            <div class="form-group">
                                <label for="password">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" placeholder="Nhập mật khẩu" required>
                            </div>

                            <!-- Address -->
                            <div class="form-group">
                                <label for="address">Địa chỉ</label>
                                <input type="text" class="form-control" id="address" placeholder="Nhập địa chỉ" required>
                            </div>

                            <!-- Address2 -->
                            <div class="form-group">
                                <label for="address2">Địa chỉ 2</label>
                                <input type="text" class="form-control" id="address2" placeholder="Nhập địa chỉ 2">
                            </div>

                            <!-- City -->
                            <div class="form-group">
                                <label for="city">Thành phố</label>
                                <input type="text" class="form-control" id="city" placeholder="Nhập thành phố" required>
                            </div>

                            <!-- State -->
                            <div class="form-group">
                                <label for="state">Tỉnh/Thành phố</label>
                                <input type="text" class="form-control" id="state" placeholder="Nhập tỉnh/thành phố" required>
                            </div>

                            <!-- Zip -->
                            <div class="form-group">
                                <label for="zip">Mã bưu điện</label>
                                <input type="text" class="form-control" id="zip" placeholder="Nhập mã bưu điện" required>
                            </div>

                            <!-- Checkbox -->
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="checkMeOut">
                                <label class="form-check-label" for="checkMeOut">Check me out</label>
                            </div>

                            <!-- Button -->
                            <button type="submit" class="btn btn-primary btn-block">Sign in</button>
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
    