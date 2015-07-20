# Codename Epidemic

### Business Requirement
- 사용자는 기간별, 장르별 순위 검색이 가능해야 한다.
- 사용자는 기간별, 장르별, 가수명, 앨범명에 따라 음악 정보 검색이 가능해야 한다.
- 사용자는 검색 창에서 자동 완성 기능을 사용할 수 있어야 한다. (단 영어만)
- 통계는 나중에...

### Engineering Requirement
- 데이터는 실시간으로 (병렬) 수집 및 가공되어야 한다. (e.g. Log Collector, Mapper/Reducer)
- 각 분산 서버는 관리가 가능해야 한다. (e.g. ZooKeeper)
- High Availability 시스템을 목표로 한다. (e.g. auto-scaling, fail-over/fail-back management, notification)

### Standardization
tbd...

### Architecture
tbd...