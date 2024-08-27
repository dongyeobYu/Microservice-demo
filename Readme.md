
# Learn to MSA Service

First Service(port: 8081), Second Service(port: 8082) -> 1번 서버, 2번 서버 \

Eureka Server -> Service Discovery, Registration(서버 찾기 및 등록) \

gateway Service -> 요청을 알맞는 서버에 포워딩


## 로드밸런서 구조 

1. http://localhost:8080/first-service/welcome 이라는 요청이 들어옴
2. Eureka Service 에 먼저 전송되고 해당 요청에 맞는 서비스를 gateway service 에 전달함
3. gateway service 는 전달받은 정보를 가지고 포워딩함 


## 로그밸런서 하는 방법

1. 로그밸런서를 사용할 서비스중 Eureka discovery 를 제외한 모든 서비스에 eureka client(dependency) 추가
2. 
