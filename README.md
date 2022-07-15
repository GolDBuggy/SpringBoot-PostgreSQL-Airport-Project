# SpringBoot-PostgreSQL-Airport-Project
SpringBoot  Airport Project


Bilgi: 
Bir tane havayolları planlama API'si geliştirmeniz ve uçuş bilgilerinde;
- Uçuş kodu
- Kalkış ve iniş havalimanı kodu
- Tarih ve Zaman
olmalıdır ve aynı 2 güzergah arasında günde maksimum 3 uçuş yapılmalıdır.

---------------------------

PostgreSQL Tablolar:
```
create table airport(
    airport_id serial primary key,
    airport_code varchar(8) unique not null,
    airport_location varchar(25) not null
);


create table ticket(
    ticket_id text unique not null,
    departure varchar(8) ,
    departure_date timestamp ,
    turn varchar(8) ,
    turn_date timestamp,
    ticket_customer int,
    buy_date timestamp default current_timestamp,
    
    constraint tk_own foreign key(ticket_customer) references customer(customer_id),
    constraint air_dep foreign key(departure) references airport(airport_code),
    constraint air_turn foreign key(turn) references airport(airport_code)

);


create table customer(
  customer_id serial primary key,
  customer_name varchar(45) not null,
  customer_mail varchar(45) not null,
  customer_phone varchar(11) not null
);

insert into airport(airport_code,airport_location) values('SBHGKN34','İstanbul')
insert into airport(airport_code,airport_location) values('ISTNBL34','İstanbul')
insert into airport(airport_code,airport_location) values('ESNBGA01','Ankara')
insert into airport(airport_code,airport_location) values('KYA42','Konya')

```


---------------------------


```
localhost:8080/ticket/save => 
{
    "departure":"SBHGKN34",      
    "departureDate":"16-07-2022",
    "turn":"ESNBGA01",
    "turnDate":"17-07-2022",
    "customer":{
        "id":1,
        "name":"İbrahim",
        "mail":"ibrahim@gmail.com",
        "phone":"05323323232"
    }
}

```
