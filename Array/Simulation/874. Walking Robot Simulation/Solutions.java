/*
| Approach                                   | Time Complexity | Space Complexity |
| ------------------------------------------ | --------------- | ---------------- |
| **Simulation + HashSet (Obstacle Lookup)** | **O(N + K)**    | **O(K)**         |

*/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<List<Integer>> set = new HashSet<>();

        for (int[] pair : obstacles) {
            set.add(Arrays.asList(pair[0], pair[1]));
        }
        int x=0;
        int y=0;
        char dir='N';
        int dist=0;
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-1){
                if(dir=='N'){
                    dir='E';
                }else if(dir=='E'){
                    dir='S';
                }else if(dir=='S'){
                    dir='W';
                }else if(dir=='W'){
                    dir='N';
                }
            }else if(commands[i]==-2){
                if(dir=='N'){
                    dir='W';
                }else if(dir=='E'){
                    dir='N';
                }else if(dir=='S'){
                    dir='E';
                }else if(dir=='W'){
                    dir='S';
                }
            }else{
                int k=commands[i];
                for(int j=1;j<=k;j++){
                    if(dir=='N'){
                        y++;
                        if(set.contains(Arrays.asList(x,y))){
                            y--;
                            dist=Math.max(dist,x*x+y*y);
                            break;
                        }else{
                           dist=Math.max(dist,x*x+y*y);
                        }
                    }else if(dir=='S'){
                         y--;
                          if(set.contains(Arrays.asList(x,y))){
                            y++;
                            dist=Math.max(dist,x*x+y*y);
                            break;
                        }else{
                           dist=Math.max(dist,x*x+y*y);
                        }
                    }else if(dir=='E'){
                         x++;
                        if(set.contains(Arrays.asList(x,y))){
                            x--;
                            dist=Math.max(dist,x*x+y*y);
                            break;
                        }else{
                           dist=Math.max(dist,x*x+y*y);
                        }
                    }else if(dir=='W'){
                         x--;
                        if(set.contains(Arrays.asList(x,y))){
                            x++;
                            dist=Math.max(dist,x*x+y*y);
                            break;
                        }else{
                           dist=Math.max(dist,x*x+y*y);
                        }
                    }
                }
            }

        }
        return dist;
    }
}
