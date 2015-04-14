# Example Makefile for automatic testing of lab solutions in EDAF05
#
# Run 'make test' or 'make testall' to perform the tests.


# Search for .out files:
# Change to make sure the path is where the testdata is stored on your system.
TESTDIR=testfiles
OUTS=$(wildcard $(TESTDIR)/*-out.txt)


test :
	java   Gale  $(TESTDIR)/sm-kt-p-4-in.txt | diff -q $(TESTDIR)/sm-kt-p-4-out.txt -
	java   Gale  $(TESTDIR)/sm-kt-p-5-in.txt | diff -q $(TESTDIR)/sm-kt-p-5-out.txt -	


testall :  $(OUTS:-out.txt=.test)

%.test : %-in.txt
	java  Gale  $< | diff -q $*-out.txt -