# Role-Based Access Control (RBAC) - Node.js + Express + JWT (CommonJS)

## Description
Simple demo backend showing role-based access using JWT tokens. Use `/login` to obtain a token (POST body should contain id, username, password, role).
Protected routes:
- GET /admin-dashboard    (Admin only)
- GET /moderator-panel   (Moderator or Admin)
- GET /user-profile      (User, Moderator, or Admin)

## Run
1. Install dependencies
   ```bash
   npm install
   ```
2. Start server
   ```bash
   npm start
   ```
3. Test with Postman or curl:
   - Login:
     POST /login
     Body JSON: { "id":1, "username":"adminUser", "password":"admin123", "role":"Admin" }

   - Use returned token in Authorization header as: `Bearer <token>` to access protected routes.
