def String customFunc(String P1,String P2){
    def dateEnd = new Date().parse("MM.dd.yyyy",P1)
    def dateStart = new Date().parse("MM.dd.yyyy",P2)
    def dateDiff = dateEnd.minus(dateStart)
	return dateDiff.toString();
}
