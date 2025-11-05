# 🚀 Deploy Full Stack App on AWS with Load Balancing

## 🧠 Objective
Deploy a React + Node.js full stack application on AWS with an **Application Load Balancer (ALB)** for scalability and fault tolerance.

## 🗂 Directory Structure
```
aws-fullstack-app/
├── frontend/        # React app (deployed to EC2 or S3)
│   └── src/
└── backend/         # Node.js + Express API (behind ALB)
```

## ⚙️ Deployment Steps
1. Launch **two EC2 instances** for backend and install Node.js.
2. Run backend using:
   ```bash
   npm install
   npm start
   ```
3. Launch another EC2 instance (or use S3) for the React frontend.
4. Replace `YOUR_BACKEND_PUBLIC_DNS_OR_LOAD_BALANCER` in `frontend/src/App.js` with your ALB DNS name.
5. Create an **Application Load Balancer** in AWS and add your backend EC2 instances as targets.
6. Access your app using the ALB DNS or Route 53 domain.

## ✅ Expected Output
- React frontend accessible via browser.
- Backend API reachable and load-balanced via AWS ALB.
- High availability ensured.
