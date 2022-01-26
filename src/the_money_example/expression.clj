(ns the-money-example.expression
  (:require [the-money-example.money :as money]))

(defn redu [source to]
      (let [amount (+ (-> source  :augend :amount) (-> source  :addend :amount))]
        (money/->Money amount to)))
