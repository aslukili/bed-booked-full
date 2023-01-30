# Use an official Node.js runtime as the base image
FROM node:18-alpine

# Set the working directory in the container to /app
WORKDIR /app

# Copy the package.json and package-lock.json files from the host to the container
COPY package*.json ./

# Install the npm dependencies
RUN npm install

# Copy the rest of the files from the host to the container
COPY . .

# Build the Angular application
RUN npm run build

# Use an official NGINX runtime as the base image
FROM nginx:alpine

# Copy the built Angular application from the previous step to the NGINX container
COPY --from=0 /app/dist/bed-booker-front /usr/share/nginx/html/

# Copy the NGINX configuration file from the host to the container
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 80 in the container
EXPOSE 80

# Start NGINX
# CMD ["nginx", "-g", "daemon off;"]
