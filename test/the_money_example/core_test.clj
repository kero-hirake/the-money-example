(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.dollar :as usd]))

(deftest money-test
  (testing "timesで掛け算"
    (testing "5 USD * 2 = 10 USD"
      (let [five (usd/->Dollar 5)]
        (is (= 10 (usd/times five 2)))))))
