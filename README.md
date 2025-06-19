# PortOne 원달러샵 (One Dollar Shop)

이 프로젝트는 PortOne(구 아임포트) 결제 시스템을 통합한 간단한 온라인 쇼핑몰 애플리케이션입니다. 사용자는 상품을 주문하고 PortOne을 통해 결제할 수 있습니다.

## 프로젝트 소개

이 애플리케이션은 Spring Boot 기반의 웹 애플리케이션으로, 다음과 같은 기능을 제공합니다:

- 사용자 등록 및 관리
- 상품 주문 처리
- PortOne을 통한 결제 처리
- 결제 성공/실패 처리

## 기술 스택

- Java 17
- Spring Boot 3.1.0
- Spring Data JPA
- Thymeleaf
- H2 Database
- PortOne(아임포트) 결제 시스템
- Lombok

## 요구사항

- JDK 17 이상
- Gradle
- PortOne(아임포트) 계정 및 API 키

## 설치 및 실행 방법

1. 프로젝트 클론
   ```bash
   git clone https://github.com/yourusername/portone-onedollar-shop.git
   cd portone-onedollar-shop
   ```

2. PortOne API 키 설정
   `src/main/java/seaung/onedollarshop/global/config/AppConfig.java` 파일에서 PortOne API 키와 시크릿 키를 설정합니다:
   ```java
   String apiKey = "your_api_key";
   String secretKey = "your_secret_key";
   ```

3. 애플리케이션 빌드 및 실행
   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```

4. 웹 브라우저에서 접속
   ```
   http://localhost:8080
   ```

## 사용 방법

1. 홈페이지 접속 (`/`)
   - 메인 페이지에서 "주문페이지로 이동" 링크를 클릭합니다.

2. 주문 페이지 (`/order`)
   - "주문하기" 버튼을 클릭하여 자동으로 주문을 생성합니다.
   - 주문이 성공하면 "결제 페이지로 이동" 링크가 활성화됩니다.

3. 결제 페이지 (`/payment/{orderUid}`)
   - "결제하기" 버튼을 클릭하여 PortOne 결제 창을 엽니다.
   - 결제 정보를 입력하고 결제를 진행합니다.

4. 결제 결과
   - 결제 성공 시: 성공 페이지로 이동합니다. (`/success-payment`)
   - 결제 실패 시: 실패 페이지로 이동합니다. (`/fail-payment`)

## 프로젝트 구조

```
src/main/java/seaung/onedollarshop/
├── domain/
│   ├── entity/         # 도메인 엔티티 (Member, Order, Payment)
│   ├── repository/     # 데이터 액세스 레이어
│   └── service/        # 비즈니스 로직
├── global/
│   └── config/         # 애플리케이션 설정
├── web/
│   ├── controller/     # 웹 컨트롤러
│   └── request/        # 요청 DTO
└── OnedollerShopApplication.java  # 메인 애플리케이션 클래스
```

## 데이터베이스

이 프로젝트는 H2 인메모리 데이터베이스를 사용합니다. 애플리케이션 실행 중에 다음 URL에서 H2 콘솔에 접근할 수 있습니다:
```
http://localhost:8080/h2-console
```

접속 정보:
- JDBC URL: `jdbc:h2:mem:onedoller-shop`
- Username: `sa`
- Password: (비어 있음)

## 개발 참고사항

- PortOne 결제 모듈은 테스트 모드로 설정되어 있습니다. 실제 결제를 처리하려면 프로덕션 키로 변경해야 합니다.
- 현재 구현은 카드 결제만 지원합니다. 다른 결제 방법을 추가하려면 payment.html 파일을 수정하세요.
- 보안을 위해 실제 배포 시에는 API 키와 시크릿 키를 환경 변수나 외부 설정 파일로 관리하는 것이 좋습니다.

## 라이센스

이 프로젝트는 MIT 라이센스 하에 배포됩니다.