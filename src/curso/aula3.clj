(ns curso.aula3)
; Aprendi aqui a usar um hasmap que é como um array, porem esse da pra associar um elemento no outro, é um tipo de colção associativa. Usa {}
; Aprendi que keys buscam as chaves dentro dos arrays ou hasmaps. pode ser definido com strings porem a forma correta é com : 
; Aprendi que o count é o mesmo do lenght do js, conta quando elementos tem no array ou hasmaps.
; Aprendi a associar dentro de um hasmap algum novo ou substituir elemento com mais um dado, usamos asssoc.
; Aprendi a tirar do hasmap com dissoc.
; Aprendi a usar o update-in, ele consegue mexer nos elementos dento do hasmap, ele consegue atualizar por ex: {:mochila{ :quantidade 2, :preco 40}} ele atualiza os valores la dentro do hasmap.
; Aprendi que as threading funcionam para nos ajudar a percorrer as estruturas aninhadas, é a mais comum de se usar por ser mais facil de entender.

(def estoque {"Mochila", 10, "Camiseta", 5})
((println estoque))
(println "temos" (count estoque) "elementos.")
(println "As chaves são" (keys estoque))

(def estoqueKeyWords {:Mochila, 15, :Camiseta, 15})
(println "As chaves são" (keys estoqueKeyWords))
(assoc estoqueKeyWords :Cadeira, 10 );localmente
(def estoqueKeyWords (assoc estoqueKeyWords :Cadeira, 10)); alterou o simbolo
(println(assoc estoqueKeyWords :Mochila, 10));local 
(println(update estoqueKeyWords :Mochila inc)); relembrando o update que relaciona a uma função
(defn tira-um
  [valor]
  (println "função que tira um")
  (- valor 1))
(println (update estoqueKeyWords :Mochila tira-um))
(println (update estoqueKeyWords :Mochila #(- % 3)))
(println (dissoc estoqueKeyWords :Mochila)) ; retira do hasmap dissoc

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})
(println "\n\n\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)

(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira 0))
(println (get pedido :cadeira {}))

;Mais comun de ser usado
(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {}))
(println (:quantidade (:mochila pedido)))

;update-in.
(println (update-in pedido [:mochila :quantidade] inc))

;outra maneira de navegadar pra dentro é o threading.
;essa é a maneira mais tradicional pra entrar nos codigos aninhados, usando THREADING.
(println(-> pedido
    :mochila
    :quantidade))