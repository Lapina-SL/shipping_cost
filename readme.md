В расчете используется 4 параметра.
В расстоянии учитываются следующие граничные значения: 2, 10, 30, также следует учесть вариант если введено значение <=0. Необходимо проверить результат вычисления в каждом интервале и на граничных значениях. Отсюда варианты -1, 0, 1, 2, 9, 10, 20, 30, 40. Получаем 9 вариантов.
Параметр хрупкости имеет 2 варианта значений, габариты 2 варианта и загруженность 4 варианта.
С учетом этого мы получим 9 * 2 * 2 * 4 = 144 тест кейса.
Для того чтобы сократить количество тестов и избавиться от избыточности воспользуемся техникой попарного тестирования параметров.
Кейсы расстояния -1 и 0 приведут к исключению их не имеет смысла комбинировать с остальными. То есть они приведут к 2 тест-кейсам и у нас остается еще 7 вариантов значений параметра для комбинаций с остальными параметрами. Будем комбинировать различные варианты пар «расстояние-хрупкость», «хрупкость-габариты» и «габариты-загруженность». Кроме того нужно учесть сценарии когда итоговая сумма оказалась менее 400 и случай когда хрупкий груз пытаются доставить на расстояние более 30 км

№	Расстояние	Хрупкость	Габариты	Загруженность	Результат
1	-1         	-	        -	        -	    Ошибка
2	0          	-	        -	        -	    Ошибка
3	1	        Да	        большой	    1	    550.00
4	1	        Нет	        маленький	1	    400.00
5	2	        Да	        маленький	1.2 	540.00
6	2	        Нет	        большой 	1.2	    400.00
7	9	        Да	        большой	    1.4 	840.00
8	9	        Нет	        маленький	1.4 	400.00
9	10	        Да	        маленький	1.6 	800.00
10	10	        Нет	        большой	    1.6	    480.00
11	20	        Да	        большой	    1	    700.00
12	20	        Нет	        маленький	1	    400.00
13	30	        Да	        большой	    1.2	    840.00
14	30	        Нет	        маленький	1.2	    400.00
15	40	        Нет	        маленький	1.6	    640.00
16	40	        Да	        большой	    1.4	    Ошибка

В задании не указан формат входных данных и выходных, поэтому у меня лишь один из вариантов решения задачи.
И параметр расстояния я бы ограничила сверху.