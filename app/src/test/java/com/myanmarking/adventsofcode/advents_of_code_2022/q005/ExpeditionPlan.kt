package com.myanmarking.adventsofcode.advents_of_code_2022.q005

data class ExpeditionPlan(
    val supplies: ShipSupplies,
    val commands: List<Command>
) {
    fun execute(moveType: MoveType) {
        commands.onEach { command ->
            when (moveType) {
                MoveType.SINGLE -> {
                    supplies.move(
                        amount = command.amount,
                        from = command.from,
                        to = command.to
                    )
                }

                MoveType.GROUP -> supplies.groupMove(
                    amount = command.amount,
                    from = command.from,
                    to = command.to
                )
            }
        }
    }
}