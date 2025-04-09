-- 샘플 상품 데이터
INSERT INTO products (name, price, category, in_stock, description, created_at)
VALUES
    ('스마트폰 A', 850000, 'electronics', true, '최신 프로세서를 탑재한 고성능 스마트폰', CURRENT_TIMESTAMP),
    ('노트북 X', 1350000, 'electronics', true, '가벼운 무게와 강력한 성능의 프리미엄 노트북', CURRENT_TIMESTAMP),
    ('무선 이어폰', 220000, 'electronics', true, '노이즈 캔슬링 기능을 갖춘 무선 이어폰', CURRENT_TIMESTAMP),
    ('스마트워치', 280000, 'electronics', true, '건강 모니터링 기능이 강화된 스마트워치', CURRENT_TIMESTAMP),
    ('태블릿 P', 790000, 'electronics', true, '선명한 화질과 펜 기능을 지원하는 태블릿', CURRENT_TIMESTAMP),
    ('블루투스 스피커', 125000, 'electronics', true, '휴대가 간편한 방수 블루투스 스피커', CURRENT_TIMESTAMP),
    ('게이밍 모니터', 450000, 'electronics', false, '고주사율 지원 게이밍 모니터', CURRENT_TIMESTAMP),
    ('기계식 키보드', 180000, 'electronics', true, '커스텀 가능한 기계식 게이밍 키보드', CURRENT_TIMESTAMP),
    ('외장 SSD', 160000, 'electronics', true, '초고속 데이터 전송 가능한 외장 SSD', CURRENT_TIMESTAMP),
    ('웹캠', 95000, 'electronics', true, '고화질 화상회의용 웹캠', CURRENT_TIMESTAMP),

    ('면 티셔츠', 25000, 'clothing', true, '부드러운 소재의 기본 면 티셔츠', CURRENT_TIMESTAMP),
    ('청바지', 65000, 'clothing', true, '편안한 착용감의 슬림핏 청바지', CURRENT_TIMESTAMP),
    ('후드 집업', 70000, 'clothing', true, '따뜻한 기모 안감의 후드 집업', CURRENT_TIMESTAMP),
    ('캐주얼 셔츠', 55000, 'clothing', false, '데일리룩에 어울리는 캐주얼 셔츠', CURRENT_TIMESTAMP),
    ('니트 스웨터', 85000, 'clothing', true, '보온성이 좋은 니트 스웨터', CURRENT_TIMESTAMP),

    ('쿠킹 포트', 78000, 'kitchenware', true, '다용도 스테인리스 쿠킹 포트', CURRENT_TIMESTAMP),
    ('프라이팬 세트', 120000, 'kitchenware', true, '코팅 처리된 프라이팬 3종 세트', CURRENT_TIMESTAMP),
    ('식기 세트', 65000, 'kitchenware', true, '심플한 디자인의 도자기 식기 세트', CURRENT_TIMESTAMP),
    ('전기 케틀', 42000, 'kitchenware', false, '빠른 가열 속도의 전기 케틀', CURRENT_TIMESTAMP),
    ('커피 머신', 185000, 'kitchenware', true, '홈카페를 위한 반자동 커피 머신', CURRENT_TIMESTAMP);
