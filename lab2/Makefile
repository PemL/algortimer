# Example Makefile for automatic testing of lab solutions in EDAF05
#
# Run 'make test' or 'make testall' to perform the tests.


# Search for .out files:
# Change to make sure the path is where the testdata is stored on your system.
TESTDIR=testfiles
OUTS=$(wildcard $(TESTDIR)/*-out.txt)


test :
	java   Lab2  $(TESTDIR)/words-10.txt $(TESTDIR)/words-10-in.txt | diff -q $(TESTDIR)/words-10-out.txt -
	java   Lab2  $(TESTDIR)/words-250.txt $(TESTDIR)/words-250-in.txt | diff -q $(TESTDIR)/words-250-out.txt -
	java   Lab2  $(TESTDIR)/words-5757.txt $(TESTDIR)/words-5757-in.txt | diff -q $(TESTDIR)/words-5757-out.txt -
	


testall :  $(OUTS:-out.txt=.test)

%.test : %-in.txt
	java  Lab2  $< | diff -q $*-out.txt -