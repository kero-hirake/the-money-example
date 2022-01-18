(ns the-money-example.bank
  (:require [the-money-example.money :as money]))

(defn redu [source to]
  (money/->Money 10 :USD) 
  )

