(ns curso.aula4)
; Aprendi a desestruturar um vetor, colocando dois valores na função e colocando no hasmaps
; Aprendi que usamos o threading last quando devemos usar map ou reduce.porque é nescessario usar o padrao dos mesmos.
; Aprendi a usar o comp.


(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})
(defn imprime-e-15 [[chave valor]]
  (println chave "e" valor)
  chave)
(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))
(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

;mesma coisa só que feito com função,porem nao é nao natural
(defn total-do-pedido [pedido]
  (reduce + (map preco-dos-produtos pedido)))
(println (total-do-pedido pedido))

;mesma coisa mas trabalhando com threading, mais comum, usamos aqui o threading last porque as funções map e reduce nescessitaam que seja passado função e dps parametro
(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals;para pegar a chave do produto
       (map preco-total-do-produto)
       (reduce +))
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

;filter
(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :brinde {:quantidade 1}})
(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))


(println "Filtrando gratuitos")
(println (filter gratuito? (vals pedido)))

;desconstruindo
(defn gratuito?
  [[chave item]]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos")
(println (filter gratuito? pedido))

;utilizando lambda.
(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos")
(println (filter #(gratuito? (second %)) pedido))
;(println (filter (fn [[chave item]] (gratuito? item)) pedido))

;utilizando o comp pra verificar se é pago ou nao
(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))