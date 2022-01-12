(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.core :refer :all]))

(deftest money-test
  (testing "multiplicatoin"
    (let [five (->Doller 5)]
      (t/is (= 10 (times five 2))))))
