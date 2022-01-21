(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.dollar :as usd]))

(deftest money-test
  (testing "timesで掛け算"
    (testing "5 USD * 2 = 10 USD"
      (let [five (usd/->Dollar 5)
            product (usd/times five 2)]
        (is (= 10 (:amount product)))))
    (testing "5 USD * 3 = 15 USD"
      (let [five (usd/->Dollar 5)
            product (usd/times five 3)]
        (is (= 15 (:amount product))))))
  (testing "等価性比較"
    (testing "5 USD = 5 USD"
      (is (usd/eq (usd/->Dollar 5) (usd/->Dollar 5))))
    (testing "5 USD != 6 USD"
      (is (not (usd/eq (usd/->Dollar 5) (usd/->Dollar 6)))))))
