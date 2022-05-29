# Online Store Springboot Microservices Angular

## Softwares Pre-requisite
  - JDK (Java Development Kit) 1.8
  - Node.js (16.15.0) + NPM (8.5.5)

## How to Run the project

  ### Run Discovery Server
    1. Open command prompt and navigate to project folder 'discovery-server' i.e 'cd <Project Folder>\online-store-springboot-angular\discovery-server'
    2. Run the command: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the command: 'java -jar discovery-server-0.0.1-SNAPSHOT.jar'
	
  ### Run Product Service
    1. Open command prompt and navigate to project folder 'product-service' i.e 'cd <Project Folder>\online-store-springboot-angular\product-service'
    2. Run the command: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the command: 'java -jar product-service-0.0.1-SNAPSHOT.jar'

  ### Run Cart Service
    1. Open command prompt and navigate to project folder 'cart-service' i.e 'cd <Project Folder>\online-store-springboot-angular\cart-service'
    2. Run the command: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the command: 'java -jar cart-service-0.0.1-SNAPSHOT.jar'

  ### Run API Gateway
    1. Open command prompt and navigate to project folder 'api-gateway' i.e 'cd <Project Folder>\online-store-springboot-angular\api-gateway'
    2. Run the command: 'gradlew clean build'
    3. Navigate to folder 'build\libs'
    4. Run the command: 'java -jar api-gateway-0.0.1-SNAPSHOT.jar'

  ### Run Angular Frontend
    1. Open command prompt and navigate to project folder 'frontend' i.e 'cd <Project Folder>\online-store-springboot-angular\frontend'
    2. Run the command: 'npm install'.  
    4. Run the command: 'npm start'. Application will open up in a browser.

### Frontend Url
Angular application will run on default Port(4200). So, application can be accessed using: 'http://localhost:4200/'
