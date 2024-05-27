FROM node:20

WORKDIR /app
# copies package.json into /app. /app isn't in the local machine, rather it is in an image
COPY package*.json . 
#Install dependencies
RUN npm install
#Copy from local machine to docker image
COPY . .
#Expose the port of the application
EXPOSE 3000

#Start the application
CMD [ "npm", "run","preview" ]
