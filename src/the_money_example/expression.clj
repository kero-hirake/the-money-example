(ns the-money-example.expression
  (:require [the-money-example.money :as money])
  (:import [the_money_example.money Money]))

(defn redu [source to]
  (if (= (class source) Money)
    source
    (let [amount (+ (-> source  :augend :amount) (-> source  :addend :amount))]
      (money/->Money amount to))))
