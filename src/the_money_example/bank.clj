(ns the-money-example.bank
  (:require [the-money-example.money :as money]))

(defprotocol IBank
  (redu [this source to]))

(defrecord Bank []
  IBank
  (redu [this source to]
        #_(expr/redu source to)
        (let [sum source
              amount (+ (-> sum  :augend :amount) (-> sum  :addend :amount))]
          (money/->Money amount to))))

