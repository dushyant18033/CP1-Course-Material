//RAM__RAM

#include<bits/stdc++.h>
using namespace std;
typedef long long int long long int;



long long int ar[1007][1007];


void aux(long long int ar[1007][1007],long long int n)
{
  
  long long int i,j;
  for(i=1;i<=n;i++)
  {
    for(j=1;j<=n;j++)
    {
      ar[i][j]=0;
    }
  } 
}

void func(long long int aux[500],long long int ar[1007][1007],long long int n)
{
  long long int i,j;
  aux[0]=1;
  aux[1]=2;
  aux[2]=4;
  aux[3]=5;
  aux[4]=8;
  aux[5]=10;
  aux[6]=14;
  aux[7]=1;
  long long int m=0;

  for(j=1;j<=n;j++)
  {
    long long int k=0;
    long long int e=0;
    i=1;
    while(i<=n)
    {
      if(i+m>n)
        ar[(i+m)%n][j]=2;
      else if(i+m<=n)
        ar[i+m][j]=2;
      
      i=i+aux[e];
      e++;

      if(i==46)
          i=24352453543;      
    }
    m++;
  }
}

void printhava(long long int ar[1007][1007],long long int n)
{
  long long int i,j;
  for(i=1;i<=n;i++)
  {  
    for(j=1;j<=n;j++)
    {    
      if(ar[i][j]==2)
        cout<<"O";
      else
        cout<<".";
    }
    cout<<"\n";
  }  
}


int main() 
{
  ios_base::sync_with_stdio(false);cin.tie(NUlong long int);

  long long int m1;
  cin>>m1;
  long long int j1=1;
  for(j1=1;j1<=m1;j1++)
  {

    long long int n;
    cin>>n;
    long long int i,j;
    aux(ar,n);

    long long int aux[500];
    func(aux,ar,n);
    
    printhava(ar,n);
  }
    return 0;   
}