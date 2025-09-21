## 1️⃣ Принцип DRY
Общая логика вынесена в абстрактный класс `ValueObject<T>`:
- Проверка `value != null`
- Реализация `equals`, `hashCode`, `toString`
- Хранение `value`

Если бы каждый `Name`, `Email`, `Phone` и т. д. реализовывал это сам, код бы дублировался во множестве классов.

**Ссылка на код:** [ValueObject.java](https://github.com/This-Git1/Store/blob/main/src/main/java/user/value/ValueObject.java)

---

## 2️⃣ Magic values
Применено: `MIN_LENGTH`, `MAX_LENGTH` вынесены в константы → магии нет.

**Ссылка на код:** [Name.java (строка 24)](https://github.com/This-Git1/Store/blob/073fdf77eeb09d8850dcf5320e4f59ffd0f6465c/src/main/java/user/value/Name.java#L24)

---

# SOLID-принципы в классе `UserService`

## 3️⃣ SRP — Single Responsibility Principle (Принцип единственной ответственности)
Класс `UserService` отвечает только за бизнес-логику работы с пользователями (в данном случае это обёртка над репозиторием).

Он не занимается доступом к базе напрямую — этим управляет `UserRepository`.  
✅ **SRP соблюдён**, потому что `UserService` имеет одну ответственность: координация операций с пользователями.

**Ссылка на код:** [UserService.java](https://github.com/This-Git1/Store/blob/main/src/main/java/user/service/UserService.java)

---

## 4️⃣ OCP — Open/Closed Principle (Принцип открытости/закрытости)
Класс `UserService` открыт для расширения: можно добавлять новые методы или расширять логику без изменения репозитория.

Закрыт для модификации верхнего уровня: мы не меняем код, чтобы использовать другой репозиторий — достаточно внедрить новую реализацию `UserRepository`.  
✅ **OCP соблюдён** благодаря интерфейсу/абстракции `UserRepository`.

**Ссылка на код:** [UserRepository.java](https://github.com/This-Git1/Store/blob/main/src/main/java/user/repository/UserRepository.java)

---

## 5️⃣ LSP — Liskov Substitution Principle (Принцип подстановки Барбары Лисков)
`UserRepository` — это абстракция (интерфейс). Любая его реализация (`MapUserRepository`, `JpaUserRepository`) может быть подставлена в `UserService` без нарушения работы.  
✅ **LSP соблюдён**.

**Ссылка на код:** [UserService.java](https://github.com/This-Git1/Store/blob/073fdf77eeb09d8850dcf5320e4f59ffd0f6465c/src/main/java/user/service/UserService.java#L10)

---

## 6️⃣ ISP — Interface Segregation Principle (Принцип разделения интерфейсов)
`UserService` зависит от узкого интерфейса `UserRepository`, который содержит только методы, необходимые сервису (`save`, `findById`).  
✅ **ISP соблюдён**, так как сервис не зависит от лишних методов репозитория.

**Ссылка на код:** [UserRepository.java](https://github.com/This-Git1/Store/blob/main/src/main/java/user/repository/UserRepository.java)

---

## 7️⃣ DIP — Dependency Inversion Principle (Принцип инверсии зависимостей)
`UserService` не создаёт конкретный репозиторий сам (`new UserRepositoryImpl()` не используется).

Он зависит от абстракции (`UserRepository`), а конкретная реализация внедряется через конструктор.  
✅ **DIP соблюдён**

**Ссылка на код:** [UserService.java (строка 10)](https://github.com/This-Git1/Store/blob/073fdf77eeb09d8850dcf5320e4f59ffd0f6465c/src/main/java/user/service/UserService.java#L10)
