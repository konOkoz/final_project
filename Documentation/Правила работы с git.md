Правила работы с git
1. Создаем проект и его основу в репозитории в ветке main (лид)
2. Создаем ветку dev и отправляем ее в репозиторий (лид)
3. Создаем ветку от dev, которая назыавется features/{id-задачи-jira}-название
4. Делаем задачу, отправляем в удаленный репозиторий
5. Делаем pull request на ветку dev
6. Лид(либо другой разработчик) может проверить pull request и оставить комментарии
7. Разработчик смотрит комментарии и вносит изменения в свою ветку
8. Лид(либо другой разработчик) может подтвердить изменения и слить ветку feature с веткой dev
-------
Другие разработчики могут у себя обновить dev, чтобы получить новые изменения
Возможные ситуации:
- Если несколько разработчиков внесли изменения в один и тот же файл - могут быть конфликты при слияниях
	- Их можно решать прям в github.com выбирая нужный вариант кода.
- Если в какой-то старой задаче обнаружен неработающий код, а он уже в dev
	- Делаем ветку от dev, которую можно назвать fixes/{описание того, что исправляете} и делаем pull request с этой ветки на dev, например fixes/EP-40-list-of-books-returns-null
-------
В самом конце проекта лид сливает ветку dev в ветку main
В идеале - каждую задачу должен ревьювить другой разработчик и лид


-----------------------------------------------------------------------------------

### Алгоритм:
1. Создали папку проекта, склонировали туда репозиторий.
2. Зашли в проект, сразу поменяли ветку на dev.
3. Посмотрели в Jira, есть ли там задание для вас или подходящее.
4. Если нет задания, можно самому придумать. 1 пердложение. Записать его в Jira. Посмотреть какое название у этого задания(например G4-46 Creation of repositories. Project creation. Adding documentation to the project.)
5. Идем в проект в IntelliJ IDEA или VSCode и создаём там новую ветку - дочернюю от ветки dev!! Для этого нужно находиться в ветке dev и создать новую. Название новой ветки пишем такое: "features/название-фичи-которую-вы-делаете" Название должно быть сокращенное (например: "features/G4-46-Project-creation-Adding-documentation")
6. Комитим эту ветку с комментарием: краткое описание фичи(пару слов)
7. Пушим.
8. Заходим на Гит и оформляем PollRequest, выбрав дочернюю ветку на ветку dev (этот пункт для ЛИДА). Я его ещё не до конца проработал. Надо потренироваться )

Не забывайте вписывать мини задачки на свои действия. Так у нас будет движуха в Jira и будет видно кто чем занимается.