(ns curso.aula2)
; Aprendi a usar o get para pegar o array, pois ele ja tem um tratamento de erro caso eu coloque um numero que nao exista no array e tem como vc tratar o que responde caso nao exista (println (get array 17 aqui coloca o que quer exibir caso nao exista pode ser tudo, numero, string))
; Aprendi que o conj adiciona no final do array, porem apenas no local onde adicionou, pois o vetor é imutavel.
; Imutabilidade do vetor.
; Aprendi a somar ou subtrair vetor usando update e inc ou dec (update preco 0 inc), mas é imutavel entao só funciona local.
; Aprendi tbm que posso usa update e uma função pra somar ou subtrair.
; Aprendi a usar o map, ele mapeia no sentido matematico da coisa, então ele vai mapear e aplicar alguma função em algum iterável.
; Aprendi a usar o filter, que diferante do map que só pega todos os valores e aplica, o filter mapeia e filtra em quais valores voce quer aplicar.
; Aprendi que usar even? quer dizer se é par?

(def precos [30, 100 , 700, 800, 900])

(println "Preços:" (precos 0))
(println "tratamento de erro:" (get precos 17 "Não existe no array"))

(println (conj precos 70))
(println precos)

(println (update precos 0 inc))
(println (update precos 1 dec))
(println precos)

(defn soma
  [valor]
  (println "Estou somando:" valor)
  (+ valor 30))

(println (update precos 0 soma))
(println precos)


; Codigo do core
(defn aplica-desconto?
  [valor-bruto]
  (println "Chamando função que aplica o desconto.")
  (> valor-bruto 100))


(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto 0.10
          desconto  (* valor-bruto taxa-de-desconto)]
      (println "Valor do desconto:" desconto)
      (println "total:" (- valor-bruto desconto)))
    (println "Total:" valor-bruto)))

(println (valor-descontado 1150))
(println (valor-descontado 100))

;mapeando a função valor-descontado e aplicando pro array de precos.
(println (map valor-descontado precos))

;mapeando a função e filtrando e aplicando o que eu quero e onde eu quero. 
(println (range 10))
(println (filter even? (range 10)))
(println "Array de preços" precos)
(println "Filter em quais valores vao ter desconto no array:" (filter aplica-desconto? precos))
(println "map após o filter" (map valor-descontado (filter aplica-desconto? precos)))

