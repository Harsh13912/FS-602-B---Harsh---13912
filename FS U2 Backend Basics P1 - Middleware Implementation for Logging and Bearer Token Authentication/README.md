# Middleware Implementation for Logging and Bearer Token Authentication

## Setup
```bash
npm install express
node server.js
```

## Routes
- **GET /public** → Accessible to everyone.
- **GET /protected** → Requires `Authorization: Bearer mysecrettoken`.

## Testing
### Public Route
```bash
curl http://localhost:3000/public
```

### Protected Route
```bash
curl -H "Authorization: Bearer mysecrettoken" http://localhost:3000/protected
```

### Invalid Token
```bash
curl -H "Authorization: Bearer wrongtoken" http://localhost:3000/protected
```
