pipeline {
    agent any  // This means the pipeline can run on any available agent

    environment {
        // Set environment variables for your Java setup
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21'  // Ensure this is the correct path to JDK 21
        MAVEN_HOME = 'C:\\Program Files\\Apache\\maven\\apache-maven-3.9.6'  // Ensure this is the correct path to Maven
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository using credentials
                git credentialsId: 'github-credentials', url: 'https://github.com/sam28mehrotra/FirstJenkinsJob.git', branch: 'master'
            }
        }

        stage('Set up WebDriver') {
            steps {
                // PowerShell script to download and set up ChromeDriver on Windows
                bat '''
                # Download ChromeDriver ZIP
                Invoke-WebRequest -Uri https://chromedriver.storage.googleapis.com/114.0.5735.90/chromedriver_win32.zip -OutFile C:\\tmp\\chromedriver.zip
                
                # Extract the ZIP file
                Expand-Archive -Path C:\\tmp\\chromedriver.zip -DestinationPath C:\\webdrivers
                
                # Optionally, add chromedriver to the PATH
                setx PATH "C:\\webdrivers\\chromedriver.exe;%PATH%"
                '''
            }
        }

        stage('Build') {
            steps {
                // Run Maven to install dependencies and build the project (without running tests)
                bat 'mvn clean install -DskipTests=true'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the TestNG tests using Maven (specifying the testng.xml file)
                bat 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publish test results in Jenkins using the JUnit plugin
                junit '**/target/surefire-reports/TEST-*.xml'  // Adjust this path if necessary
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
