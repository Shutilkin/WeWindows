# Use an official Node.js runtime as the base image
FROM node:18

# Set the working directory in the container
WORKDIR my-nodejs-project

# Copy package.json and package-lock.json from the project directory
COPY ./package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the project directory
COPY ./ ./

# Expose the port your app listens on
EXPOSE 3000

# Command to run the application
CMD ["node", "index.js"]
