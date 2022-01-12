(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.core :refer :all]))

(deftest money-test
  (testing "5 USD * 2 = 10"
    (let [five (->Dollar 5)
          product (times five 2)]
      (is (= 10 (:amount product)))))
  (testing "5 USD * 3 = 15"
    (let [five (->Dollar 5)
          product (times five 3)]
      (is (= 15 (:amount product)))))
  )
