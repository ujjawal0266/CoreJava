package sealedClasses;

public sealed class PremiumFruite permits Mango,Apple{

}
final class Mango extends PremiumFruite {

}
sealed class Apple extends PremiumFruite permits King,Ring{

}
final class King extends Apple{

}
final class Ring extends Apple{

}

