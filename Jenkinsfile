pipeline {
    agent any

    environment {
        // Docker imajı ve container için kullanacağımız isim
        IMAGE_NAME = "spring-boot-cicd-app"
        CONTAINER_NAME = "spring-boot-cicd-container"
        PORT = "8080"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'GitHub repository klonlanıyor...'
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                echo 'Maven ile Spring Boot projesi derleniyor (Testler atlanıyor)...'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Docker imajı oluşturuluyor...'
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Docker Deploy') {
            steps {
                echo 'Önceki container varsa durdurulup siliniyor...'
                sh """
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true
                """

                echo 'Yeni Docker container başlatılıyor...'
                // Jenkins 8080'de çalıştığı için uygulamamızı 8081 portundan yayınlıyoruz
                sh "docker run -d --name ${CONTAINER_NAME} -p 8081:8080 ${IMAGE_NAME}"
            }
        }
    }
}
