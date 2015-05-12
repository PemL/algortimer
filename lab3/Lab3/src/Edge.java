
class Edge implements Comparable<Edge>
{
    String v1,v2;
    int w;

    Edge(String v1, String v2, int w)
    {
        this.v1=v1;
        this.v2=v2;
        this.w=w;
    }

    @Override
    public int compareTo(Edge o) {
        Edge e1 = (Edge)o;
        if(e1.w==this.w)
            return 0;
        if (e1.w < this.w) {
        return 1;
        }
        else return -1;
    }

}