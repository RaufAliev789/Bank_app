# Spring Core Bank Application

Полнофункциональное банковское приложение на Java с использованием Spring Core для управления пользователями и операциями со счетами.

## Технологии

- **Java 25** - язык программирования
- **Spring Framework 7.1** - IoC контейнер и управление зависимостями
- **Maven** - система сборки проекта
- **Jakarta Annotations** - управление жизненным циклом бинов

## Возможности

✅ Управление пользователями (создание, поиск)  
✅ Управление счетами (создание, пополнение, снятие, закрытие)  
✅ Переводы между счетами с комиссией 1%  
✅ Интерактивный консольный интерфейс  
✅ Внедрение зависимостей через Spring

## Архитектура

### Слои приложения

- **Presentation Layer** - консольное взаимодействие (OperationConsoleListener)
- **Business Logic Layer** - сервисы (UserService, AccountService)
- **Data Model Layer** - модели данных (User, Account)
- **Infrastructure** - конфигурация Spring

### Компоненты

- `User` - модель пользователя
- `Account` - модель банковского счета
- `UserService` - управление пользователями
- `AccountService` - финансовые операции
- `OperationCommandProcessor` - обработчики операций (Strategy Pattern)
- `OperationConsoleListener` - главный диспетчер консоли

## Как запустить

```bash
# Клонирование репозитория
git clone https://github.com/RaufAliev789/Bank_app.git
cd Bank_app

# Сборка проекта
mvn clean install

# Запуск приложения
mvn exec:java -Dexec.mainClass="aliev.dev.App"
```

## Использование

При запуске приложения вы сможете:

1. **USER_CREATE** - создать нового пользователя
2. **SHOW_ALL_USERS** - просмотреть всех пользователей
3. **ACCOUNT_CREATE** - создать счет для пользователя
4. **ACCOUNT_DEPOSIT** - пополнить счет
5. **ACCOUNT_WITHDRAW** - снять средства со счета
6. **ACCOUNT_TRANSFER** - перевести деньги между счетами
7. **ACCOUNT_CLOSE** - закрыть счет

## Конфигурация

Параметры приложения находятся в `src/main/resources/application.properties`:

```properties
account.default-amount=500        # Начальный баланс нового счета
account.transfer-comission=0.01   # Комиссия при переводе между пользователями
```

## Автор

(tg: @Alira87)

