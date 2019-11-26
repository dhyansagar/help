
# Implement three nodes point – to – point network with duplex links between them.
# Set the queue size, vary the bandwidth and find the number of packets dropped.

set ns [new Simulator]
set na [open Lab1.nam w]
$ns namtrace-all $na
set nt [open Lab1.tr w]
$ns trace-all $nt
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
$ns duplex-link $n0 $n1 10Mb 10ms DropTail
$ns queue-limit $n0 $n1 1
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns queue-limit $n1 $n2 1
set TCP [new Agent/TCP]
$ns attach-agent $n0 $TCP
set CBR [new Application/Traffic/CBR]
$CBR attach-agent $TCP
set SINK [new Agent/TCPSink]
$ns attach-agent $n2 $SINK
$ns connect $TCP $SINK
proc End {} {
global ns na nt
$ns flush-trace
close $na
close $nt
exec nam Lab1.nam &
exit 0
}
$ns at 0.0 "$CBR start"
$ns at 50.0 "End"
$ns run
