# Online Store Springboot Microservices Angular

## Softwares Pre-requisite
  - JDK (Java Development Kit) 1.8
  - Node.js (16.15.0) + NPM (8.5.5)

## How to Run the project

  ### Run Discovery Server
    1. Navigate to project folder 'discovery-server'
    2. Run the following command on command prompt: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the following command on command prompt: 'java -jar discovery-server-0.0.1-SNAPSHOT.jar'
	
  ### Run Product Service
    1. Navigate to project folder 'product-service'
    2. Run the following command on command prompt: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the following command on command prompt: 'java -jar product-service-0.0.1-SNAPSHOT.jar'

  ### Run Cart Service
    1. Navigate to project folder 'cart-service'
    2. Run the following command on command prompt: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the following command on command prompt: 'java -jar cart-service-0.0.1-SNAPSHOT.jar'

  ### Run API Gateway
    1. Navigate to project folder 'api-gateway'
    2. Run the following command on command prompt: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the following command on command prompt: 'java -jar api-gateway-0.0.1-SNAPSHOT.jar'

  ### Run Angular Frontend
    1. Navigate to project folder 'frontend'
    2. Run the following command on command prompt: 'npm install'.  
    4. Run the following command on command prompt: 'npm start'. Application will open up in a browser.

### Frontend Url
Angular application will run on default Port(4200). So, application can be accessed using: 'http://localhost:4200/'
