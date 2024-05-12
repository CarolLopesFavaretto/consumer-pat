package br.com.alelo.consumer.consumerpat.entity;

public enum EstablishmentType {

    DRUGSTORE(CardType.DRUGSTORE_CARD) {
        public Double applyRule(Double value) {
            return value;
        }
    },
    FOOD(CardType.FOOD_CARD) {
        public Double applyRule(Double value) {
            Double cashback = (value / 100) * 10;
            return value - cashback;
        }
    },
    FUEL(CardType.FUEL_CARD) {
        public Double applyRule(Double value) {
            Double tax = (value / 100) * 35;
            return value + tax;
        }
    };
    public CardType type;

    public abstract Double applyRule(Double value);

    EstablishmentType(CardType cardType) {
        this.type = cardType;
    }
}
