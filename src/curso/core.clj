(ns curso.core)
; Aprendi que os operadores ou o que vai ser executado sempre tem que ser colocado primeiro nos parenteses ex: (+ 1 7) , (println "bla bla bla"), (println (função)) e (println (array 0))
; Aprendi a usar a função println.
; Aprendi a definir variaveis globais def, variaveris locais *(let).
; Aprendi a definir funções defn sempre tem que passar parametro [].
; Aprendi a fazer as condicionais com if, when e sem nada disso só passando a condição.
; Aprendi que as condições não se coloca else, o else é sempre a ultima a ser feita, dentro do if ainda.
; Aprendi funções anonimas.

(defn aplica-desconto?
  [valor-bruto]
  (println "Chamando função que aplica o desconto com if e else")
  (if (> valor-bruto 100)
    true
    false))


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


(defn aplica-desconto?
  [valor-bruto]
  (println "Chamando função que aplica o desconto com when")
  (when (> valor-bruto 100)
    true
    false))


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

#_((defn mais-caro-que-100?
     [valor-bruto]
     (println "Chamando função mais caro que 100.")
     (> valor-bruto 100))

   (defn valor-descontado
     [aplica? valor-bruto]
     (if (aplica? valor-bruto)
       (let [taxa-de-desconto 0.10
             desconto  (* valor-bruto taxa-de-desconto)]
         (println "Valor do desconto:" desconto)
         (println "total:" (- valor-bruto desconto)))
       (println "Total:" valor-bruto)))

   (println (valor-descontado mais-caro-que-100? 1150))
   (println (valor-descontado mais-caro-que-100? 100)))