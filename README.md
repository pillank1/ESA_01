# Лабораторная работа №1 JavaEE

В данной лабораторной работе было написано приложение с использованием общей архитектуры и технологий JavaEE. В качестве СУБД была использована posgreSQL. Была создана простая модель Player/Hero со связью один ко многим и соединением Hero к Player через player_id:

![изображение](https://user-images.githubusercontent.com/70959898/217813742-2f733567-201b-4bb9-b7b9-0d066d8899c1.png)

В процессе создания приложения были созданы сущности, сервлеты, бины и DAO  для запросов к БД и обработки полученных данных. Также для демонстрации работы приложения были написаны jsp. Пример работы приложения показан ниже.

## Главная страница:

![Main Page 1](https://user-images.githubusercontent.com/70959898/217818227-7c9a5666-1478-45cf-a0b6-08c0db49528a.PNG)

## Создание игрока:


![Create Player 1](https://user-images.githubusercontent.com/70959898/217817002-fe362a0e-ec6e-48b8-8ce9-2ede5ea60bde.PNG)
![Create Player 2](https://user-images.githubusercontent.com/70959898/217817017-7bad087a-0672-48f6-8e31-7694cbc959d8.PNG)

## Создание героя:


![Create Hero 1](https://user-images.githubusercontent.com/70959898/217816907-9d96acae-ce81-498d-9738-d6182b2d8fa2.PNG)
![Create Hero 2](https://user-images.githubusercontent.com/70959898/217816930-6c5f8524-4b38-4a91-996d-0d5cfd3fbe31.PNG)

## Изменение игрока:


![Update Player 1](https://user-images.githubusercontent.com/70959898/217817040-f92de59e-5034-496e-8f54-2cef564072bf.PNG)
![Update Player 2](https://user-images.githubusercontent.com/70959898/217817050-efc3f636-0d3b-4fee-9833-351b93220dac.PNG)

## Изменение героя:


![Update Hero 1](https://user-images.githubusercontent.com/70959898/217817071-211c6eb0-82eb-465f-8013-0c2fe5cee84d.PNG)
![Update Hero 2](https://user-images.githubusercontent.com/70959898/217817077-76cd9a05-1672-46a8-a8ef-afaa557a1423.PNG)

Также в лабораторной работе возможно и удаление отдельного игрока(к которому не прикреплен герой), героя, игрока с его героями вместе(когда удаляешь игрока, то удаляется сам игрок и все его герои).
