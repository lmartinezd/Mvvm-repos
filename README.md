
# MVVM-Repos

O app MVVM-Repos utiliza o padrão de arquitetura MVVM e Clean Architecture.
Foi utilizado o [Git API](https://api.github.com/) para obter as informações do projeto.


##  Main Features :books:
1. Kotlin
2. MVVM
3. ViewBiding
4. Retrofit
5. Koin
6. Coroutines
7. LiveData
8. Glide


##  Architecture and Libraries :books:
Foi utilizado o padrão de arquitetura MVVM que ajuda na separação de atribuições entre as camadas da lógica e regra de negócio com a camada visual, View. Além beneficia na prática de realizar testes unitários e instrumentados de maneira mais desacoplada. 
<br/><br/>
Para chamadas assíncronas foi utilizado Coroutines e junto com o LiveData, auxilia na comunicação reativa entre as Activities e o ViewModel. No quesito de requisições HTTP foi utilizada a libreria Retrofit.
<br/><br/>
Seguindo outro Design Pattern, é importante o uso de uma injeção de dependência. Nesse projeto, foi utilizado o Koin, para facilitar a injeção de objetos.
