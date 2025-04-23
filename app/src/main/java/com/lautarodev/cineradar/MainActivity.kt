package com.lautarodev.cineradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.google.gson.Gson
import com.lautarodev.cineradar.ui.theme.CineRadarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineRadarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CineListScreen(
                        CineRadarList = getCineRadarResult(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun getCineRadarResult(): List<shows> {
    val gson = Gson()
    return gson.fromJson(json, Array<shows>::class.java).toList()
}





var json = """
{
  "itemType": "show",
  "showType": "movie",
  "id": "414",
  "imdbId": "tt1877830",
  "tmdbId": "movie/414906",
  "title": "Batman",
  "overview": "Tras dos años vigilando las calles en la piel de Batman y sembrando el miedo entre los criminales, Bruce Wayne se adentra en las más tenebrosas sombras de Gotham. El justiciero solitario se ha erigido como la única encarnación de la venganza en una ciudad donde sus aliados son escasos y la corrupción abarca toda una red de funcionarios y altos cargos. Cuando la élite de Gotham se ve amenazada por las maquinaciones de cierto asesino, un rastro de enigmáticas pistas conducirá al mejor detective del mundo hasta los bajos fondos de la ciudad, donde se topará con Catwoman (Selina Kyle), el Pingüino (Oswald Cobblepot), Carmine Falcone y Enigma (Edward Nashton). A medida que las pistas comienzan a apuntar hacia su entorno y el calibre del plan del asesino queda revelado, Batman deberá forjar nuevas alianzas, desenmascarar al culpable y llevar ante la justicia la corrupción y el abuso de poder que durante tanto tiempo han asolado Gotham.",
  "releaseYear": 2022,
  "originalTitle": "The Batman",
  "genres": [
    {
      "id": "action",
      "name": "Acción"
    },
    {
      "id": "crime",
      "name": "Crimen"
    }
  ],
  "directors": [
    "Matt Reeves"
  ],
  "cast": [
    "Robert Pattinson",
    "Zoë Kravitz",
    "Jeffrey Wright",
    "Colin Farrell",
    "Paul Dano",
    "John Turturro",
    "Andy Serkis"
  ],
  "rating": 77,
  "runtime": 176,
  "imageSet": {
    "verticalPoster": {
      "w240": "https://cdn.movieofthenight.com/show/414/poster/vertical/es/240.jpg?Expires=1769116314&Signature=RctvdS3UzyFhzWk5M9DzeYEVQteh3zB~znJiRJJIyy2dmHaT6RYB6EvMO-Fw4I-naLy~sZOz7XjDMz7bGZFlIEro2rX9u04F9YP1rT4JgjqDwivuP78DGBEq4cdjIh5jMacgMA5NRFaDvnDYDrmoHjcv0sZVexTn6RqjVXkCMFAi8xVWoSUYBCrxNU7IjgDltBNu-SbSHKYYgz-CENLWi0nHAwVzsqDDmXlcsaYrMj2tvA2lS4eg~2ngBNMpYVeXRFJ-6q68wwaNQHmNGAmHpiLlh9SZzDCUivJqWQoRKrgRCSwIKyFBIVWr~YCpDmuhiv9DHU3fngQJP7LXXQwfZA__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w360": "https://cdn.movieofthenight.com/show/414/poster/vertical/es/360.jpg?Expires=1769116314&Signature=jmhKMIodpt5kYfaqejrK~2yCFMoQD1YDkttF5dwbDHEhYWrnA7zfALVi9pkrn7YQ1ZNr9mth0czI5vbpe2NZuC3ARXJ-SBpuhhbtX6~OVKGWRXunZNcQtUtrhsVvHv2fbwwJTyHNBg~76y6H3sy1Y5hUUTPtQbIBfg-yFxUWZ1PdupHzxl~KazAK~5eJeec-ITutwuZQDv5nZIbVbVKlg7DoY~mS5R6o8Iv5p44bA16dmgBdlzQTTWwAadlUE2URFcrCuyoKr7-hsNn76JCBegcR4meqWVf-QYWQUVv35z7kR2Jy-kcWFnMtpf8qjU~~EjA5C6RWuClD7w~lvTmsJw__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w480": "https://cdn.movieofthenight.com/show/414/poster/vertical/es/480.jpg?Expires=1769116314&Signature=ThZUmEzonH~HoAsJBkEhcfKMzQ5JiHnudgX2AJAvxx9YkDL8t6~44W9jTZq9dhLczwmbTYaiYQmGgw15PIf0VSjlqjZN4-dHOzLCzEanwQP7fRlrOqbrZEg2Bap3aAxWA4Y~NuNh5SIlJeeXz9QYMBRHyRgDyWwFG9k4iLLmwzpvhFMyt7mnFY-zW2ChTK4f5GEnRLg2bfyHP-jhbrSMuvLZsBSo4CovBj4yYGDFHsanAmH0yV0mW5vS36RlkRAD8pewSsxHuhDuUxweJz3B2SlNs5TgYFU28aYgBAbErU4oYXPUEP9bvg9lTscVMQCJswmRExLCp5E~2fxaWcBRXw__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w600": "https://cdn.movieofthenight.com/show/414/poster/vertical/es/600.jpg?Expires=1769116314&Signature=MceD4824pWMrow~sMmd08QUH39pUajFaJyKApDcfwWsdgHH-0vBEo2-ioB82XZK0DGMeAPkzE~u3R5MxkSFxsdLoKwpY7eZPoYo3AdzgfraiPVC0DUUNGWqPar1zDCsUqBCt4BfhlP1kzDa7j43DublEWIl2PRMvy0u-IRoYESwO7EeIksHx9w7g9GnlUvrG0VE~Vn5PLvrFZotYtp7sZHcDcKfI9aNbpL3kEIMQK9fO3u9yfn~SCV2SN0DNwPMojgm6PtCP11CjtL04LKCCfpJaX7O0-6xHUNB3Q2rXVBHPajyd9NTluWyL7o65dXmW1BxWHC6QKNqP2eFuJPL6hA__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w720": "https://cdn.movieofthenight.com/show/414/poster/vertical/es/720.jpg?Expires=1769116314&Signature=NXi9JuHKAUsOU-ZVtkzUbpHBMLlt5VkvcycJxlemlOkkDZk4TXwCrAy~r3EA8H0jebz7YxYZ3Gq2cKPdqaAnFMR7oSK-lHHm1PspmbkVFQp5eJdQ5xvauvqqSpj6KD~q7ktosfO8Su7uLmpKvM7L-zT8YEMcbc--2KPItz6o-Po8Po6eYwdWlJOfkyW5ao7WZ9IQrdsqojs~2vvrSGuRJDuHmjtZKmFhKUc71YULzfBT25rjI7e8L~sES4Hk3UBEhjCODyloMer8UMCQWCoOdPn8EgrsLzMRFdcCSfYOiVTWFLDSwJpaUBgBQkoojVELefKmqSmfH1G3QALd9ZgKug__&Key-Pair-Id=KK4HN3OO4AT5R"
    },
    "horizontalPoster": {
      "w360": "https://cdn.movieofthenight.com/show/414/poster/horizontal/es/360.jpg?Expires=1769116317&Signature=ZM~ky7N6sJcv7C1GYr6Ki4ynLIsBh9wzHqslVd8AnvHMxftJONswuTH6QzoyFtd~Lc-go1l6lnqql6JbKKNAaE1HqlwtbAj9ZMPEVEqjye7oA6fBPYOS0NsMwaApW9vyiKsJdCNfYe76V0HI42Klvrd-uKeks~y17ilwRwbh6SkNtcdayz2~FonOkXZzlMhjF70RWcKp8VhsyGZvrh~Q5F0bvLHEobtY22eqMWQPhbSzWm6M0EepoDoZhl42o47jnAwKzxa5sCRHn8tHEEQtEhEzQKGfnn2OkUb8J6SbHmjnug4nfq6t3EdwonrHq-fTAwOTaqcl2GJzI-jSMGwq~w__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w480": "https://cdn.movieofthenight.com/show/414/poster/horizontal/es/480.jpg?Expires=1769116317&Signature=GQ6nLBO0tSsJfiJnq2fgJo4-ZAu2B3V36da00J~RJTvnJgxNOBv7RLTl4GV~H-PA-Y2C-mGby8LTol8yc~t01QXkmHFmdv8aBXXiZOOHF0nBZTB5JXhhD9ycrlbU7qwI3wJwIDbPNhGnALmlln1ZKoQ3o2FW7do9i5vBT6NbPCWLktURMzf2I891pTxvKxidZcSySOBxgnN6v4KSPqLGVvF8DdjK1N6d3ibsE~ihqQXaknQJfSHxG0P4smLbyYfuVZL6Dj9nsEVv0TZXLlq8TkrL~4hOkMsN7DeI2jnUH2JpajN2S7pZuzRVvvK5trpw1-a58Bgzy3eLXFfs9b6dlw__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w720": "https://cdn.movieofthenight.com/show/414/poster/horizontal/es/720.jpg?Expires=1769116317&Signature=GSx2v~LuQetXc3xgQMKkk9OIrLcrRQaj5FvXzoblCI8tV373C5FZ1Gt1RQfPohVI3ctoPQdlZo90laoD4HmwvHj9vdRT~rthIgYP~LEU5JUdqP-Kl8-p6fl1FwQ8lZVkjnBMIsaEC2LqrmBQQk5NJTq9Risur2sF-D4u93XyW0eWtHH6bWyXJNy2mFXZUoJvSu5kBetx2qFtDAkAr~hhnmmE1Y2Qyh6ozym0DcAVcK8u9lGC2VWAQeT42tpUTmNQauzUKoFN6lzh5uFsdVLA8N2uXiE5C9t2Ut2f8JWDXleKmFKMXMVy1-zYNRWzeLTgaWHW6RUyHEYTMjOe2um7LA__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w1080": "https://cdn.movieofthenight.com/show/414/poster/horizontal/es/1080.jpg?Expires=1769116317&Signature=DCn~woSO5v4mZVwV2AkvENFhZts5akyeV37CsqImpDxA6kOy-UjMVxhYicoTM4MWaZSIe3xzk~wozwQHJBbxCPr5HCFUU0EnuISGth5uqdkkPxBzgWcghIg4zgcjZ2llPKyW0~XXr5E70VTTUhkVhEevPEQtJM9qwRAPDtZoXwfJ2j1zYRTIjunq49wNlDBdP2k~01Iqk2K-y29ZsUj0eem1HB4OhmMLOBrCItcoop8rlOsZ-LFMsA-z7CYXon0IAKnJin3HOnYcBR9aXdl4uWb-Ul0ky04Hhc7NSPSjXY-jWAQwQ0hE7ZZ8TPaeiGiiHID5sP89Me1wgLh1-QRPCQ__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w1440": "https://cdn.movieofthenight.com/show/414/poster/horizontal/es/1440.jpg?Expires=1769116317&Signature=XQupAL3di3633i81AzDqe0LZjRJfvKt3i1HKH1BCy9fcbgFmJk9PE8DdGw7wF~TZ49G4P4-ylZIwhLPgPJNUYGA1v1B8MZwyKRHIZcKBdWfCTrkLZN0Tp-4OZa-~t0qKr2cBxFRoB9j~mD6ONaWTGJi9XF~uhSzqGHBRH2ah2QUvVs2MfH52O1kVavu0pqWi8AhNOgqIb5Jdc0uyfLpxWNwnUHFLwja2IPYhIkiysCZyEntmq2WOfK1kxdqYwEcuFsXroZwuduQTEbb7SzmaiHhBrwucClsNSDgfmr3sr6P6t9rrF1hvFRONAV2CIBCC~Y3sITqcOlud1u30pYWnfA__&Key-Pair-Id=KK4HN3OO4AT5R"
    },
    "verticalBackdrop": {
      "w240": "https://cdn.movieofthenight.com/show/414/backdrop/vertical/240.jpg?Expires=1769116292&Signature=TDIx8EGBPri1-nAI~yGPFoqimWuFJW2h2qEMQ~pk3uKHQaO6Ct4V-KtGteDaQUMR7Xt5jgCdzGJgsNQaB5D0c48euBGabeftgqtKAKWcf3d373xT6LT1ZK1RgCoy7BAKtxzcrG9yIrT0ftCVF6CFhkzxXbviQWUWfcConwPRKBjyG5~mOqYXBwjNNUkbM2OymiRlCIOmtGIRhgzhUrmvPZZry6k4ScxituMDjInQ6F6IXnspQQiCCIZhkikWyqk0~aqnQlLV~EdOvpw9AvqwbfHkbT0ZnXpviHZdxPj7p9h9xBH-QdiMOUnKLFZvFj4GzMOHXCxd45lSLnrQMfFZIQ__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w360": "https://cdn.movieofthenight.com/show/414/backdrop/vertical/360.jpg?Expires=1769116292&Signature=hqvK2VY-mYLung-kOe0KTw1WMd6BaII5gVvKc505vvGfcibxkP6~xXsB4vWVw8j4EZNxT7vBg9-dvspi1i1gygJj0UUqkZSa-qKZK7idMMjp8hspdD5YWR-mDBKn~7VllYQ9-sAYkR6XkAJFwh9xFIFEy93QUe9axeY3IUL9cJJ~qpXliM~NqEOreayB1glQuVQp-jUq-gcEokdIft4OV9bblniX9~pbFLTqNXg3xIxruyn9OsfnQPtg1AxJmRuh6Cq5OG~Rs6JurR4kFQcGaQSfJ~C-pbFIGZQQ~Q4UNsaMPAijnt2a6eGmi1Fq7cVywoNvKCVlVlW8qrOZVL4gHA__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w480": "https://cdn.movieofthenight.com/show/414/backdrop/vertical/480.jpg?Expires=1769116292&Signature=OCGySwRodxG0iP2ajRnnoLuwhtdcLWCsnfqN7syCij1XZTjuyPbmSsupPagBOlg6FPjdqpOWjsVl0G1zhenQfa99E0CX3eqv81uhtdMDUH8zFsRYsaZsK-Hvd8g09S6PuqxhmMmm05Xuxtoaz3KKW9L5IIrXQs6D42rbutATTuiFjCi5XEhUZUm30-RfgKPaKWIABHKSZk8JqzlKemp8DXSqA1AznsxEn6jVz3x0oUuCQ4bdcGad2y9kynPholuvElM1k8NNE3DeQOt~IWh-YFVgxbpg751p6LsYzP~2oX8LqDMC401LLjU6dU4jWngQu~28X-G4qk96NfCmWKk0nA__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w600": "https://cdn.movieofthenight.com/show/414/backdrop/vertical/600.jpg?Expires=1769116292&Signature=XH2o~N14RBVnqBHAQRKoLhSz75dIiOD1InGvLHC-T1hytBgtXAADgr9PDp2uhFPhXejQUfzwEn-0X7Yg9rs1U3Tp8W5JWeOnNZr65c2pCFEMR7Xx5CyPdprheLiyiqGc~ekFkGKLXk57Opy4uey2U0BDh4FSVV2FkfMZchKwqQEUXHnk712ApXZTVFsTa0L4cZNJQlq9-s-6dUoQnPNp6FK6kYlwbmQ0HCX86qsXAxVxPnLGjfeN5PPpJtBn9hOamlMH-349ygfFbyPfTRLAmdjD8uuBwvAVkzgvdTr~lTc7wDItMr4454OqN~cREVtHKUtK8gRCU60B0oj6xpNe9g__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w720": "https://cdn.movieofthenight.com/show/414/backdrop/vertical/720.jpg?Expires=1769116292&Signature=MihWmYkAnzFefmRSwvmgLyIXjuFGMQjYe11ZQoVuqKezB1B42QO3435W2a7LHl7wzCsQBuNF3MsfARsVPT~vA0HeEUAR~Shx2ujB7wOsoonjG4idTwlj-qVC7rqqxWjMEDopu4PqJxZ9hLT9WinECXPNPJ7r0ds0PpNn-~Gii3wKrSTqco663MMnC405SNCkXjOJFfQ-E5BfH-yIC9XLc33usQVqG2zUr40rLEgAIKQQbD~WVDJV5Eh6IBsCkOuMwm65uTVm~QUh2g1ibj6VYA5scBCcvydNIWPrx4lhz3p3nkZ0bx6iUvXyZfPLlBcYOzjNBzMRSx7fvAJBjaiqWA__&Key-Pair-Id=KK4HN3OO4AT5R"
    },
    "horizontalBackdrop": {
      "w360": "https://cdn.movieofthenight.com/show/414/backdrop/horizontal/360.jpg?Expires=1769116295&Signature=TFXR8VBZWSDMjs9qC6RKNuyZvR0tKVhOl3e6tlSVa6uJGwCcJDIEq7dKeFavZ9y0KuMkaEZ6JTfhl05-DDq~PH4~XoGacy-EqFMhwH5aLON3jWLSfaRy12sW8GKn6mcBt9sRq~2PPiChZVjXbJ8yMvf3nH1KESDJZtzqXOuZlJDkz~LUUZRKR6vhHcdzkSc9l2dc2OehgPi6E9u9EfEWkwpdaCPSMIScWxALZGcB17OYpmnV3CLZHTX-HnKKfUfVuAYYeucLSUMhzmUHAS3yfPQfS9Xd7t6~jDA5-6XmKcQK72JhTsEpzKJLM42GbTAdPuLjoI6w-zylkI9c-9IGtw__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w480": "https://cdn.movieofthenight.com/show/414/backdrop/horizontal/480.jpg?Expires=1769116295&Signature=Z3dXFttAw~WT211KF24Ew3tNLgD3zx8czUFr~ynt1d8bjvMimWqcam~nA3HAb~bUtlwaQjp7nvZUFpKJl4QXHhRY-~eoND3wTAQgJqRaBgSRaCWX1V93yMOFpXrWR8a-UXJHbGAAyUwIrFgUlA7lj1kSTfU0K42wdX1q43V3Xp4IlbzCzDPhAomqVQjtP1CxPDAKNBMESR10cTZ8sCX1gSNQ0tYXmlH6xv2nWX9JReUsvBbyA60mezikM8~kcqcAVw-0HI8svpLcGnBt1f3mBisnm5JkTu2wgec7ntOJXaLItamxTfpaus7-9NFRdodxjKHGt~ZVena~FfbLZ1sweg__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w720": "https://cdn.movieofthenight.com/show/414/backdrop/horizontal/720.jpg?Expires=1769116295&Signature=AvXzdtyACaxzlNUOGpo67Ze0vRQRzlGJS0roVt0o87kV14mDqO08tBMLQeO7mJS0dWnZhBNR9qD7PoUy3qYBrxK~Pi3dMzaYOV82jyUEIWQ25AL86TZneDfxtAx3A1UYjdNhdy~Gdmuzp7uNX6bKzrHaKH6ik9snhkI2VXXNYo9AAE224cmHL0TyDW2S06YcM0qXen1nkNDmkMbOcsKicJooxzSKHJH0Bk3b46vU8FUmzpL9pThrkWPyVsiFkUNC72ZQDoQxj-y4w2qTRpUTkMxd6KIkmpc018CRBzbCY7XapQnpq3UheMTqUXAi4L-QDOGvCe3cMOSM8z~VjYmy5w__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w1080": "https://cdn.movieofthenight.com/show/414/backdrop/horizontal/1080.jpg?Expires=1769116295&Signature=C7FMS10bNZD5IHZt9Z4YfrWsBRPFikt9vWG7iHey0TH~ztX~zaZgG7XPS~GRy69pxpB5mz1T0RwgO48dYtbRMrhhbgGOwwrNjdLSb4XtJ2cpoaTAtJZtnzs1ILHNyHiyV0eVVT~sTpDoAUhpYfhavMmHWpCrJBWHs3pPAc2KC4tfAOoUXudDiz4UYzql6WAc-C3QEmLXyO1XiuxK783hraEZoDzSS6VJijYSA22QuFbYD~j1NPx2Z2UZ7mjj68Lz6jnM6fd7vDWe5SgtAMwGYZeTIjUB36jwMpcTdnZwq1vcbH-Zhi0SLDNiUvZnJY6eDCCWyOzQ36oRJO3ceYvgCg__&Key-Pair-Id=KK4HN3OO4AT5R",
      "w1440": "https://cdn.movieofthenight.com/show/414/backdrop/horizontal/1440.jpg?Expires=1769116295&Signature=dta3paNOzE0ii7mAnE4PJgxD1XHu99zUQ5YYpjTUF8kocNn5d~b0uubj1Atf4J9yxhQy~wk-3prSOU~PlyqjGSQIoZzuycCXH9OB-Oo8UakAB93AdEaMR~KYOy640S89x3oLt6L-1b1HQQeeD3wPVZFGYmc952gYaym7kV0HwJ853Pb0DaunxfhGXKKuxhM2AhjikaaXLETz9PxBJT69igWl-GSYpW-cAwcWNd-MD6qUFjJQkLIvDNSJP79jHS9IWLL2jB~SBWlS~TQqd9EP~tNsz8EMd~NBQOjSmP9xPytsDjRT0CHapdvsPUtqo1OYbTP8XWUOLcloqE29fXUj4g__&Key-Pair-Id=KK4HN3OO4AT5R"
    }
  },
  "streamingOptions": {
    "ar": [
      {
        "service": {
          "id": "apple",
          "name": "Apple TV",
          "homePage": "https://tv.apple.com/ar",
          "themeColorCode": "#000000",
          "imageSet": {
            "lightThemeImage": "https://media.movieofthenight.com/services/apple/logo-light-theme.svg",
            "darkThemeImage": "https://media.movieofthenight.com/services/apple/logo-dark-theme.svg",
            "whiteImage": "https://media.movieofthenight.com/services/apple/logo-white.svg"
          }
        },
        "type": "addon",
        "addon": {
          "id": "tvs.sbd.9050",
          "name": "HBO Max",
          "homePage": "https://tv.apple.com/ar/channel/hbo-max/tvs.sbd.9050",
          "themeColorCode": "#241450",
          "imageSet": {
            "lightThemeImage": "",
            "darkThemeImage": "",
            "whiteImage": ""
          }
        },
        "link": "https://tv.apple.com/ar/movie/batman/umc.cmc.75o96q32hcm2kzx4ilop1ylmx",
        "quality": "uhd",
        "audios": [],
        "subtitles": [],
        "expiresSoon": false,
        "availableSince": 1700582862
      },
      {
        "service": {
          "id": "apple",
          "name": "Apple TV",
          "homePage": "https://tv.apple.com/ar",
          "themeColorCode": "#000000",
          "imageSet": {
            "lightThemeImage": "https://media.movieofthenight.com/services/apple/logo-light-theme.svg",
            "darkThemeImage": "https://media.movieofthenight.com/services/apple/logo-dark-theme.svg",
            "whiteImage": "https://media.movieofthenight.com/services/apple/logo-white.svg"
          }
        },
        "type": "rent",
        "link": "https://tv.apple.com/ar/movie/batman/umc.cmc.75o96q32hcm2kzx4ilop1ylmx?playableId=tvs.sbd.9001%3A1606824145",
        "quality": "hd",
        "audios": [],
        "subtitles": [],
        "price": {
          "amount": "3.99",
          "currency": "ARS",
          "formatted": "3.99 ARS"
        },
        "expiresSoon": false,
        "availableSince": 1700582862
      },
      {
        "service": {
          "id": "apple",
          "name": "Apple TV",
          "homePage": "https://tv.apple.com/ar",
          "themeColorCode": "#000000",
          "imageSet": {
            "lightThemeImage": "https://media.movieofthenight.com/services/apple/logo-light-theme.svg",
            "darkThemeImage": "https://media.movieofthenight.com/services/apple/logo-dark-theme.svg",
            "whiteImage": "https://media.movieofthenight.com/services/apple/logo-white.svg"
          }
        },
        "type": "buy",
        "link": "https://tv.apple.com/ar/movie/batman/umc.cmc.75o96q32hcm2kzx4ilop1ylmx?playableId=tvs.sbd.9001%3A1606824145",
        "quality": "hd",
        "audios": [],
        "subtitles": [],
        "price": {
          "amount": "3.99",
          "currency": "ARS",
          "formatted": "3.99 ARS"
        },
        "expiresSoon": false,
        "availableSince": 1700582862
      },
      {
        "service": {
          "id": "hbo",
          "name": "Max",
          "homePage": "https://play.max.com/",
          "themeColorCode": "#002be7",
          "imageSet": {
            "lightThemeImage": "https://media.movieofthenight.com/services/hbo/logo-light-theme.svg",
            "darkThemeImage": "https://media.movieofthenight.com/services/hbo/logo-dark-theme.svg",
            "whiteImage": "https://media.movieofthenight.com/services/hbo/logo-white.svg"
          }
        },
        "type": "subscription",
        "link": "https://play.max.com/movie/dfa50804-e6f6-4fa2-a732-693dbc50527b",
        "videoLink": "https://play.max.com/video/watch/306aa55d-38c5-4614-b75e-ca7433887790/c463e2c8-e703-466a-bd3d-aa02668ff3cb",
        "quality": "uhd",
        "audios": [
          {
            "language": "eng"
          },
          {
            "language": "por"
          },
          {
            "language": "spa"
          }
        ],
        "subtitles": [
          {
            "closedCaptions": true,
            "locale": {
              "language": "eng"
            }
          },
          {
            "closedCaptions": false,
            "locale": {
              "language": "por"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "spa"
            }
          }
        ],
        "expiresSoon": false,
        "expiresOn": 1752807540,
        "availableSince": 1744754604
      },
      {
        "service": {
          "id": "prime",
          "name": "Prime Video",
          "homePage": "https://www.primevideo.com/",
          "themeColorCode": "#00A8E1",
          "imageSet": {
            "lightThemeImage": "https://media.movieofthenight.com/services/prime/logo-light-theme.svg",
            "darkThemeImage": "https://media.movieofthenight.com/services/prime/logo-dark-theme.svg",
            "whiteImage": "https://media.movieofthenight.com/services/prime/logo-white.svg"
          }
        },
        "type": "subscription",
        "link": "https://www.primevideo.com/detail/0TNWJYOSXYR74OY4W78E71780P/ref=atv_dp",
        "quality": "sd",
        "audios": [
          {
            "language": "eng"
          },
          {
            "language": "fra"
          },
          {
            "language": "hin"
          },
          {
            "language": "ita"
          },
          {
            "language": "kan"
          },
          {
            "language": "mal"
          },
          {
            "language": "por"
          },
          {
            "language": "spa"
          },
          {
            "language": "tam"
          },
          {
            "language": "tel"
          },
          {
            "language": "tur"
          }
        ],
        "subtitles": [
          {
            "closedCaptions": false,
            "locale": {
              "language": "dan"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "eng"
            }
          },
          {
            "closedCaptions": false,
            "locale": {
              "language": "fin"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "fra"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "ita"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "nld"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "por"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "spa"
            }
          },
          {
            "closedCaptions": true,
            "locale": {
              "language": "swe"
            }
          },
          {
            "closedCaptions": false,
            "locale": {
              "language": "tur"
            }
          }
        ],
        "expiresSoon": false,
        "availableSince": 1700903067
      }
    ]
  }
}
"""