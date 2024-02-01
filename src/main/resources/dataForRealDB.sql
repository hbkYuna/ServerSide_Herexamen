insert into book (TITLE, DESCRIPTION)
values ('Oryx and Crake', 'MaddAddam is a serie of 3 dystopian science-fiction novels that deals with extreme genetic engineering.'); /*1*/


insert into book (TITLE, DESCRIPTION)
values ('The year of the flood', 'MaddAddam is a serie of 3 dystopian science-fiction novels that deals with extreme genetic engineering.');/*2*/

insert into book (TITLE, DESCRIPTION)
values ('MaddAddam', 'MaddAddam is a serie of 3 dystopian science-fiction novels that deals with extreme genetic engineering.');/*3*/

insert into book (TITLE, DESCRIPTION)
values ('1Q84', 'Set in 1984 in Tokyo, the story concerns an assassin who stumbles upon an alternate world she refers to as 1Q84. There, she becomes embroiled in a conspiracy involving an abusive religious cult.');/*4*/

insert into book (TITLE, DESCRIPTION)
values ('De opwindvogelkronieken', 'Novel about Toru, a bored young man living a basic life in Tokyo. When Toru’s daily routines are interrupted by increasingly odd and chaotic events, he must undergo a metaphysical journey that tests the limits of free will and corporeality. ');/*5*/

insert into book (TITLE)
values ('Design Patterns');/*6*/

insert into book (TITLE, DESCRIPTION)
values ('Anderland: De Stad Van Gouden Schaduw', ''); /*7*/

insert into book (TITLE, DESCRIPTION)
values ('Anderland:  Rivier van blauw vuur', ''); /*8*/

insert into book (TITLE, DESCRIPTION)
values ('Anderland:  Berg van zwart glas', ''); /*9*/

insert into book (TITLE, DESCRIPTION)
values ('Anderland:  Zee van zilveren licht', ''); /*10*/

insert into book (TITLE, DESCRIPTION)
values ('Neuromancer ', ''); /*11*/

insert into book (TITLE, DESCRIPTION)
values ('Snow crash', ''); /*12*/

insert into book (TITLE, DESCRIPTION)
values ('Rainbows’s end', ''); /*13*/

insert into book (TITLE, DESCRIPTION)
values ('Hard-boiled wonderland en het einde van de wereld', ''); /*14*/

insert into book (TITLE, DESCRIPTION)
values ('Ready Payer one', ''); /*15*/

insert into book (TITLE, DESCRIPTION)
values ('Refactoring', ''); /*16*/

insert into book (TITLE, DESCRIPTION)
values ('Extreme Programming Explained', ''); /*17*/

insert into book (TITLE, DESCRIPTION)
values ('Implementation patterns', ''); /*18*/

insert into book (TITLE, DESCRIPTION)
values ('Clean code', ''); /*19*/


insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Margaret Atwood',
        'Margaret Atwood was born in 1939 in Ottawa and grew up in northern Ontario, Quebec, and Toronto. Throughout her writing career, Margaret Atwood has received numerous awards and honourary degrees.',
        'Canada'); /*1*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Haruki Murakami',
        'Haruki Murakami  is a popular contemporary Japanese writer and translator. His work has been described as ''easily accessible, yet profoundly complex''.',
        'Japan'); /*2*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Erich Gamma', 'One of the ''Gang of four''.', 'Switzerland'); /*3*/

insert into author (NAME, DESCRIPTION, COUNTRY)
values ( 'Richard Helm', 'One of the ''Gang of four''.', 'Australia'); /*4*/

insert into author (NAME, DESCRIPTION, COUNTRY)
values ( 'Ralph Johnson', 'One of the ''Gang of four''.', 'USA'); /*5*/

insert into author (NAME, DESCRIPTION, COUNTRY)
values ( 'John Vlissides', 'One of the ''Gang of four''.', 'USA'); /*6*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Tad Williams', '', ''); /*7*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('William Gibson', '', ''); /*8*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Neal Stephenson', '', ''); /*9*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Vernor Vinge', '', ''); /*10*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Martin Fowler', '', ''); /*11*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Kent Beck', '', ''); /*12*/

insert into AUTHOR (NAME, DESCRIPTION, COUNTRY)
values ('Robert C Martin', '', ''); /*13*/


insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (1, 1);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (2, 1);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (3, 1);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (4, 2);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (5, 2);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (6, 3);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (6, 4);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (6, 5);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (6, 6);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (7, 7);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (8, 7);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (9, 7);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (10, 7);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (11, 8);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (12, 9);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (13, 10);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (14, 2);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (15, 10);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (16, 11);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (17, 12);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (18, 12);
insert into BOOK_AUTHORS (BOOKS_ID, AUTHORS_ID)
values (19, 13);

