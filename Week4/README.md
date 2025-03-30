# Week3 : 자바 자료구조 직접 구현 (4개)

## 🎯 과제 목표
바닐라 자바로 핵심 자료구조 4종을 직접 구현하며,  
**자료구조의 내부 동작 원리**와 자바의 객체지향 설계 능력을 강화하는 것이 목표입니다.

---


## 🧩 구현 대상 자료구조 (총 4개)

### 1. **LinkedList (단일 연결 리스트)**
- 내부 `Node` 클래스 구현
- 필수 메서드
  - `add(value)`
  - `add(index, value)`
  - `remove(index)`
  - `get(index)`
  - `size()`
- 예외 처리 및 시간 복잡도 주석 필수

---

### 2. **Hash Table**
- 체이닝 방식 충돌 해결
- 필수 메서드
  - `put(key, value)`
  - `get(key)`
  - `remove(key)`
  - `resize()` (load factor 초과 시 자동 확장)
- 해시 함수 설계 및 `hashCode()`, `equals()` 이해 필요

---

### 3. **Stack (배열 기반)**
- LIFO 구조
- 필수 메서드
  - `push(value)`
  - `pop()`
  - `peek()`
  - `isEmpty()`
- 내부 배열 크기 자동 확장 (`resize()`)

---

### 4. **Queue (원형 큐, 배열 기반)**
- FIFO 구조
- 필수 메서드
  - `enqueue(value)`
  - `dequeue()`
  - `peek()`
  - `isEmpty()`
- 원형 큐 구조 구현: `front`, `rear` 인덱스 관리

---

## ✨ 추가 도전 과제 (선택)
- Stack, Queue를 **LinkedList 기반**으로도 구현
- Hash Table에서 **개방 주소법** 방식 추가 구현