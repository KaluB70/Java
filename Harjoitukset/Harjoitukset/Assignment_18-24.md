18. Make a class which holds an undefined amount of numbers.

    1.  The user must be able to insert and delete numbers from the class.

    2.  The class has a method for returning the average of the numbers.

    3.  The class holds the average of the numbers. This means the class _updates_ the average whenever necessary. Jari remembers to explain this.

    4.  After finishing part c) think: why would we ever write such code? It has _side-effects_ and as such violates f.ex. the paradigm of functional programming.

19. Make a class to hold the time of the day. The time is constructed of hours, minutes and seconds.

    1.  Make methods which increases/decreases the time.

    2.  Make a comparator which orders the time-objects into ascending order.

    3.  Make a comparator which orders the time-objects into descending order.

20. Make a class to hold a date. The date includes the number of the day, the number of the month and the number of the year. The class also holds the time of the day which it inherits from the class made in exercise 19.

    1.  Make methods which increases/decreases the date.

    2.  Make comparators (ascending and descending) which orders the dates.

21. The formula below can be used to calculate the Fibonacci numbers. We could mathematically prove that the formula is correct, but that is quite difficult, especially if you’re not a mathematician. Instead we can prove it works by coding a program to test the formula. Do that. The formula is copied from: https://fi.wikipedia.org/wiki/Fibonaccin_lukujono.

![F](https://wikimedia.org/api/rest_v1/media/math/render/svg/fa7fe08d3a58c713b0e3257c2934afd2de9bbe47)

1.  A Fibonacci number is calculated as the sum of the two previous Fibonacci numbers, i.e. F<sub>i</sub> = F<sub>i-1</sub> + F<sub>i-2</sub>. The two first numbers are 0 and 1 and after that the series continues as explained. Make a class to calculate any “nacci” series. See [<u>https://fi.wikipedia.org/wiki/Fibonaccin_lukujono</u>](https://fi.wikipedia.org/wiki/Fibonaccin_lukujono), for details.

2.  The Koodit folder includes a file named Jobs.txt. It has 1080 lines of job descriptions. A single line is constructed of

    1.  a unique _id_

    2.  a _day_ identifier (ma1-su3 = the first Monday – the last Sunday)

    3.  the _code_ of the job

    4.  the _duration_ of the job in minutes

    5.  the _starting time_ of the job

    6.  the _ending time_ of the job

Make a class to hold the values.

24. With the previous data, make data structures to hold

    1.  all the jobs in the order they are in the file

    2.  all the codes of the jobs

    3.  all job ids for every day and week, the jobs must be ordered by the ids

    4.  the amount of different codes of jobs for every week

    5.  all the codes of the jobs for every day

    6.  the amount of different starting times for every day, must be ordered by the starting time and day

    7.  all job ids for every code of job, must be ordered by the ids

> When making the structures, remember that you may want to update them.
