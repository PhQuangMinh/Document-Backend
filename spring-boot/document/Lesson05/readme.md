# [BUỔI 5] Security basic implement
- Spring security là gì ?
- JWT là gì ?
- Authentication, Authorization là gì ?
## 1. Spring Security là gì?
- **Spring Security** là một framework bảo mật cho các ứng dụng Java, đặc biệt là các ứng dụng sử dụng Spring. Nó cung cấp các cơ chế bảo mật cho việc xác thực người dùng (authentication) và phân quyền (authorization), cho phép quản lý quyền truy cập vào các tài nguyên trong ứng dụng. 
- **Spring Security** hỗ trợ nhiều phương pháp xác thực như form login, HTTP basic, OAuth, và JWT. Nó cũng cung cấp khả năng bảo vệ khỏi các tấn công phổ biến như CSRF (Cross-Site Request Forgery) và session fixation.

## 2. JWT (JSON Web Token) là gì?
- JWT là một tiêu chuẩn mở (RFC 7519) cho việc truyền tải thông tin an toàn giữa các bên dưới dạng JSON. Nó được sử dụng rộng rãi trong việc xác thực và phân quyền trong các ứng dụng web và API. Một JWT bao gồm ba phần:
    - **Header:** Chứa thông tin về loại token và thuật toán mã hóa.
    - **Payload:** Chứa các thông tin (claims) mà bạn muốn truyền tải.
    - **Signature:** Được tạo ra bằng cách mã hóa header và payload với một bí mật (secret) để đảm bảo tính toàn vẹn của token.
- JWT cho phép lưu trữ thông tin xác thực mà không cần lưu trạng thái trên server, giúp giảm tải cho server và cải thiện hiệu suất.

## 3. Authentication và Authorization là gì?
- **Authentication (Xác thực):** Là quá trình xác định danh tính của người dùng hoặc một hệ thống. Khi một người dùng đăng nhập vào hệ thống, thông tin đăng nhập của họ (thường là tên người dùng và mật khẩu) sẽ được xác thực để đảm bảo rằng họ là người mà họ nói rằng họ là. Nếu xác thực thành công, người dùng sẽ nhận được một token (như JWT) để sử dụng trong các yêu cầu tiếp theo.
- Knowledge authentication
    - password
    - pin code
    - answer to secret question
- Possession based authentication
    - Phone/text messagees
    - keycards and badges
- Multi Factor Authentication: Knowledge based + possesion based

- **Authorization (Phân quyền):** Là quá trình xác định quyền truy cập của người dùng vào các tài nguyên trong hệ thống. Sau khi người dùng đã được xác thực, hệ thống sẽ kiểm tra quyền hạn của họ để quyết định xem họ có thể truy cập vào tài nguyên cụ thể (như API, trang web, hoặc chức năng) hay không. Phân quyền có thể dựa trên vai trò (role) của người dùng (ví dụ: ADMIN, USER) hoặc các quyền cụ thể mà họ được cấp.

Granted authority(cung cap quyen han)
roles
principle là đoạn thông tin đầy đủ của người dùng