# Проект автоматизации тестирования для MTS IT Jobs

> Проект автоматизированного тестирования портала карьеры MTS Bank IT.

## 📋 О проекте

Проект включает автоматизированные тесты для [портала MTS IT Jobs](https://job.mtsbank.ru/it), охватывающие:
- Управление cookies - принятие и настройка
- Выбор города - обработка географического местоположения
- Валидацию UI компонентов
- Интеграционное тестирование пользовательских сценариев

---

## 📚 Содержание

- [Технологии и инструменты](#технологии-и-инструменты)
- [Архитектура тестов](#архитектура-тестов)
- [Тест-кейсы](#тест-кейсы)
- [Запуск тестов](#запуск-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure отчет](#allure-отчет)
- [Интеграция с TestOps](#интеграция-с-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Телеграмм-бот с уведомлениями о результатах тестов](#телеграмм-бот-с-уведомлениями-о-результатах-тестов)
- [Видео пример запуска тестов в Selenoid](#видео-пример-запуска-тестов-в-selenoid)

---

<a id="технологии-и-инструменты"></a>
## 🛠 Технологии и инструменты

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.png" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.png" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure.png" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logo/Jira.png" width="50" height="50"  alt="Jira"/></a>  
</p>

---

<a id="архитектура-тестов"></a>
## 🏗 Архитектура тестов

```bash
src/test/java/
├── tests/
│   ├── components/           # Компоненты страниц
│   │   ├── CityConfirmComponent.java
│   │   └── CookieNoticeComponent.java
│   ├── helpers/             # Вспомогательные классы
│   │   └── Attach.java      # Вложения для отчетов
│   ├── pages/               # Page Object модели
│   │   └── ItJobPage.java   # Главная страница
│   ├── BaseTest.java        # Базовый класс тестов
│   └── ItJobPageTests.java  # Тестовые классы
````


---

<a id="тест-кейсы"></a>
## ✅ Тест-кейсы

### 🍪 Тесты cookie-баннера
- ✓ Проверка отображения cookie баннера
- ✓ Проверка текста кнопок cookie баннера
- ✓ Проверка кликабельности кнопок cookie
- ✓ Успешное принятие cookies
- ✓ Проверка возможности настроить cookies
- ✓ Проверка поведения после перезагрузки страницы

### 🏙 Тесты выбора города
- ✓ Проверка отображения баннера выбора города
- ✓ Подтверждение города по умолчанию (Москва)
- ✓ Выбор другого города (Казань)
- ✓ Проверка кликабельности кнопок выбора города
- ✓ Проверка сохранения выбора города после перезагрузки

### 🔄 Интеграционные тесты
- ✓ Полный flow: cookies + город по умолчанию
- ✓ Настройка cookies + выбор другого города

---

<a id="запуск-тестов"></a>
## 🚀 Запуск тестов

### Локальный запуск всех тестов
```bash
./gradlew clean test
```
### Локальный запуск тестов с определенными тегами
```bash
./gradlew clean all_tests
./gradlew clean cookies_tests  
./gradlew clean city_tests
./gradlew clean integration_tests
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins
[Сборка в Jenkins](https://jenkins.autotests.cloud/job/001-a-efremova-lesson14/10/)
<p align="center">
    <img title="Jenkins Build" src="images/BuildJenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/AllureReport.png"> Allure-отчет
### Overview
[Allure отчет](https://jenkins.autotests.cloud/job/001-a-efremova-lesson14/10/allure/)
<p align="center">
    <img title="Allure Overview" src="images/AllureJenkins.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure.png"> Интеграция с TestOps
### Overview
[Интеграция с TestOps](https://allure.autotests.cloud/project/4910/dashboards)
<p align="center">
    <img title="Allure Overview" src="images/TestOpsDashboards.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Jira.png"> Интеграция с Jira
### Overview
[Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-1497)
<p align="center">
    <img title="Jira Integration" src="images/JiraTask.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Telegram.png"> Телеграмм-бот с уведомлениями о результатах тестов
### Overview
<p align="center">
<img width="70%" title="Telegram Notifications" src="images/TelegramBot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.png"> Видео пример запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
<video width="800" controls>
  <source src="images/VideoTest.mp4" type="video/mp4">
</video>
</p>

