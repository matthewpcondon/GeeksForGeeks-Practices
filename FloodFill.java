class Solution
{
    private int oldColor;
    private void flood(int[][] image, int sr, int sc, int newColor){
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length
        || image[sr][sc] != oldColor || image[sr][sc] == newColor){
            // base cases
            /* it needs to check both that the pixel is the same as old color,
            as well as, that the pixel is not the same as the new color 
            which doesn't make any sense, because the colors are mutually exclusive
            */
            return;
        }
        image[sr][sc] = newColor;
        flood(image, sr-1, sc, newColor); // up
        flood(image, sr, sc-1, newColor); // left
        flood(image, sr+1, sc, newColor); // down
        flood(image, sr, sc+1, newColor); // right
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        oldColor = image[sr][sc];
        
        flood(image, sr, sc, newColor);
        return image;
    }
}
/*
This is too slow, probably because it uses a linked list.
It could also be a stack overflow, because oddly, you have
to check two things that already imply one another:
you have to check
both that the pixel is the old color, as well as, that the 
pixel is not the new color.
class Pair {
    int x;
    int y;
    public Pair(int _x, int _y){
        x = _x;
        y = _y;
    }
}
class Solution{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        
        Queue<Pair> q = new LinkedList<Pair>();
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        q.add(new Pair(sr, sc));
        Pair visited;
        int x, y;
        while (!q.isEmpty()){
            visited = q.remove();
            // add the four neighbors, if they're the old color
            x = visited.x;
            y = visited.y;
            // up
            if ((x-1) >= 0 && (image[x-1][y]) == oldColor ){
                image[x-1][y] = newColor;
                q.add(new Pair(x-1, y));
            }
            // left
            if (y-1 >= 0 && (image[x][y-1]) == oldColor ){
                image[x][y-1] = newColor;
                q.add(new Pair(x, y-1));
            }
            // down
            if ( x+1 < image.length && (image[x+1][y]) == oldColor ){
                image[x+1][y] = newColor;
                q.add(new Pair(x+1, y));
            }
            // right
            if (y+1 < image[x].length &&
            (image[x][y+1]) == oldColor ){
                image[x][y+1] = newColor;
                q.add(new Pair(x, y+1));
            }
        }
        return image;
    }
	*/
