import { CircleDollarSign } from 'lucide-react'
import React from 'react'

export default function DashboardLayout({
  children
}: {
  children: React.ReactNode
}) {
  return (
    <>
      <div className="container flex h-20 max-w-full items-center m-auto gap-4 shadow-md bg-zinc-800">
        <CircleDollarSign className="text-emerald-400" size={48} />
        <h1 className="uppercase text-slate-100 font-bold text-3xl">
          Money Manager
        </h1>
      </div>
      <div className="container items-center gap-4 w-md m-auto mt-2 rounded-xl shadow-xl bg-slate-200 h-48">
        {children}
      </div>
    </>
  )
}
