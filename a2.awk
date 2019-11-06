BEGIN{Count=0;}
{
if($1=="d")
Count++;
}
END{printf("\n\n\tNumber of Packets Dropped is %d\n\n\n",Count);}